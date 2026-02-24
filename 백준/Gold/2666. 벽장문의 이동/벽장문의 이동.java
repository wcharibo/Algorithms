import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	
	static int[] revert(int point) {
        int[] temp = new int[2];
        temp[0] = Integer.numberOfTrailingZeros(point);
        point &= ~(1 << temp[0]);
        temp[1] = Integer.numberOfTrailingZeros(point);
        return temp;
    }

    static int convert(int[] point) {
        return (1 << point[0]) + (1<< point[1]);
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int min = 500;
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> prev = new HashMap<>();
		Map<Integer, Integer> post= new HashMap<>();
		
		prev.put(convert(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}), 0);
		
		int input = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < input; i++) {
			
			int target = Integer.parseInt(br.readLine());
			
			post.clear();
			
			for(Map.Entry<Integer, Integer> cur : prev.entrySet()) {
				int prev1 = revert(cur.getKey())[0];
				int prev2 = revert(cur.getKey())[1];
				int next1 = convert(new int[] {target, prev2});
				int next2 = convert(new int[] {prev1, target});
				int nextDist1 = Math.abs(target - prev1);
				int nextDist2 = Math.abs(target - prev2);
				
				if(post.containsKey(next1)) {
					post.replace(next1, Math.min(post.get(next1), cur.getValue() + nextDist1));
				}else {
					post.put(next1, cur.getValue() + nextDist1);
				}
				
				if(post.containsKey(next2)) {
					post.replace(next2, Math.min(post.get(next2), cur.getValue() + nextDist2));
				}else {
					post.put(next2, cur.getValue() + nextDist2);
				}
			}
			
			prev.clear();
			
			for(Map.Entry<Integer, Integer> cur : post.entrySet()) {
				prev.put(cur.getKey(), cur.getValue());
			}
		}
		
		
		for(Map.Entry<Integer, Integer> result : post.entrySet()) {
			min = Math.min(min, result.getValue());
		}
		
		System.out.println(min);
	}
}
