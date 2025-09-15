import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] strs = new String[N];
			
			for(int i = 0; i < N; i++) {
				strs[i] = st.nextToken();
			}
			
			int second = (N)%2 == 0 ? N/2 : N/2+1;
			
			for(int i = 0, j = second; i < second; i++, j++) {
				sb.append(strs[i]).append(" ");
				if(j < N) sb.append(strs[j]).append(" ");
			}

			result.append("#").append(tc).append(" ").append(sb.toString()).append("\n");
		}
		System.out.println(result);
	}
}
