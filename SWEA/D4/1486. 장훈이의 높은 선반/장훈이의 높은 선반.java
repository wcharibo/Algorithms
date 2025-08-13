import java.util.*;
import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] height = new int[N];
			
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				sum+=height[i];
			}
			
			int[] dp = new int[sum+1];
			
			for(int i = 0; i < N; i++) {
				for(int j = sum; j >= height[i]; j--) {
					dp[j] = Math.max(dp[j], height[i] + dp[j - height[i]]);
				}
			}
			
			int cnt = B;
			int result = dp[B];
			
			while(B > result) {
				result = dp[++cnt];
			}

			sb.append("#").append(tc).append(" ").append(cnt - B).append("\n");
		}

		System.out.println(sb);
	}
}
