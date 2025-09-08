import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] val = new int[N];
			int[] wei = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				wei[i] = Integer.parseInt(st.nextToken());
				val[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[K+1];

			for (int i = 0; i < N; i++) {

				for (int j = K ; j >= wei[i]; j--) {

					dp[j] = Math.max(dp[j], val[i] + dp[j - wei[i]]);

				}
			}

			sb.append("#").append(tc).append(" ").append(dp[K]).append("\n");
		}

		System.out.println(sb);
	}
}