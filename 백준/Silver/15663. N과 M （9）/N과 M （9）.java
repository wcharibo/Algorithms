import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static TreeMap<Integer, Integer> numbs = new TreeMap<>((a,b)-> a-b);
	static Set<List<Integer>> result = new TreeSet<>((a, b) -> {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) == b.get(i)) continue;
			else return a.get(i) - b.get(i);
		}
		return 0;
	});
	static ArrayList<Integer> arr = new ArrayList<>();
	
	static void fill(Integer cur) {
		for(int num : numbs.keySet()) {
			int numCnt = numbs.get(num);
			if(cur == M) {
				if(numCnt >= 1) {
					arr.add(num);
					result.add(new ArrayList<>(arr));
					arr.remove(arr.size()-1);
				}
			}
			else if(numCnt >= 1) {
				arr.add(num);
				numbs.put(num, --numCnt);
				fill(cur+1);
				numbs.put(num, ++numCnt);
				arr.remove(arr.size()-1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			int j = Integer.parseInt(st.nextToken());
			if(numbs.containsKey(j)) {
				numbs.put(j, numbs.get(j) + 1);
			} else numbs.put(j, 1);
		}
		
		fill(1);
		
		for(List<Integer> r : result) {
			for(int i : r) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
}