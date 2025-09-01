import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) -1;

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 1000000);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer
					.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			map[i][i] = 0;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			result[i] += map[i][X];
			result[i] += map[X][i];
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, result[i]);
		}

		System.out.println(max);
	}
}