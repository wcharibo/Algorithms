import java.util.*;
import java.awt.Point;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 100;
		int[] dirX = { 0, 0, -1 }, dirY = { -1, 1, 0 };

		for (int tc = 1; tc <= 10; tc++) {
			boolean[][] ladder = new boolean[N][N];
			boolean[][] vis = new boolean[N][N];
			int T = Integer.parseInt(br.readLine());
			Point cur = null;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 0)
						continue;
					else
						ladder[i][j] = true;

					if (temp == 2)
						cur = new Point(i, j);
				}
			}

			while (cur.x != 0) {
				for (int i = 0; i < 3; i++) {
					vis[cur.x][cur.y] = true;
					int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

					if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
						if (ladder[nextX][nextY] & !vis[nextX][nextY]) {
							cur = new Point(nextX, nextY);
							break;
						}
					}
				}
			}

			sb.append("#").append(T).append(" ").append(cur.y).append("\n");

		}
		System.out.println(sb);
	}
}