import java.util.*;
import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int k = (N-1)/2;
			int sum = 0;
			int[][] farm = new int[N][N];
			
			for(int i = 0 ; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++)
					farm[i][j] = str.charAt(j) - 48;
			}
			
			for(int i = 0; i < k; i++) {
				sum += farm[i][k];
				sum += farm[N-i-1][k];
				for(int j = 1; j <= i; j++) {
					sum+=farm[i][k-j];
					sum+=farm[i][k+j];
					sum+=farm[N-i-1][k-j];
					sum+=farm[N-i-1][k+j];
				}
			}
			
			for(int i = 0; i < N; i ++) sum+=farm[k][i];

			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
