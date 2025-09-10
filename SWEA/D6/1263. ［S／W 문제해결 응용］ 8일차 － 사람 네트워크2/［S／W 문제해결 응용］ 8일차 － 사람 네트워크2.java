import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(map[i], 100);
				map[i][i] = 0;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());
					if(cur != 0) map[i][j] = cur;
				}
			}
			
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						
					}
				}
			}
			
			int result = 50000;
			
			for(int i = 0; i < N; i++) {
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					cnt += map[i][j];
				}
				result = Math.min(result, cnt);
			}
			
//			for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
