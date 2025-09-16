import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	static HashMap<Integer, Long> map = new HashMap<>();
	
	static long dq(int a, int p) {
		if(map.containsKey(p)) {
			return map.get(p);
		}
		
		map.put(p, ((dq(a, p/2)%a) * (dq(a, p - p/2)%a))%a);
		return map.get(p);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int P = 1234567891;

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long factorialN_R = 0;
			long factorialR = 0;
			long temp = 1;
			
			for(int i = 1; i <= ((N-R) < R ? N-R : R); i++) {
				temp = (temp*(i%P)%P);
			}
			
			if(N-R < R) factorialN_R = temp;
			else factorialR = temp;
			
			for(int i = ((N-R) < R ? N-R : R) + 1; i <= ((N-R) > R ? N-R : R); i++) {
				temp = (temp*(i%P)%P);
			}
			
			if(N-R < R) factorialR = temp;
			else factorialN_R = temp;

			for(int i = ((N-R) > R ? N-R : R) + 1; i <= N; i++) {
				temp = (temp*(i%P)%P);
			}
			long factorialN = temp;
			
			map.clear();
			map.put(1, ((factorialN_R*factorialR)%P));
	
			long fermat = dq(P, P-2);

			sb.append("#").append(tc).append(" ").append((factorialN * fermat) % P).append("\n");
		}
		System.out.println(sb);
	}
}
