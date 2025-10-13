import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] office;
	static List<int[]> CCTVs;
	static int[][][] directs = { 
			{}, 
			{ { 0 }, { 1 }, { 2 }, { 3 } }, 
			{ { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, 
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } }, 
			};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];
		CCTVs = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (0 < office[i][j] && office[i][j] < 6) {
					CCTVs.add(new int[] { i, j });
				}
			}
		}

		find(new int[CCTVs.size()], 0);

		System.out.println(result);
	}

	private static void find(int[] directions, int cur) {
		if (cur == directions.length) {
			fill(-1, directions);
			result = Math.min(result, calc());
			fill(0, directions);
			return;
		}
		
		int cx = CCTVs.get(cur)[0];
		int cy = CCTVs.get(cur)[1];
		for (int i = 0; i < directs[office[cx][cy]].length; i++) {
			directions[cur] = i;
			find(directions, cur + 1);
		}
	}

	private static void fill(int val, int[] directions) {
		for (int cur = 0; cur < directions.length; cur++) {
			int dir = directions[cur];
			int cx = CCTVs.get(cur)[0];
			int cy = CCTVs.get(cur)[1];
			List<Integer> dirList = new ArrayList<>();
			dirList.add(dir);

			for (int j : directs[office[cx][cy]][directions[cur]]) {
				dirList.add(j);
			}

			for (int d : dirList) {
				for (int i = 1; i < 8; i++) {
					int nx = cx + (i * dirs[d][0]);
					int ny = cy + (i * dirs[d][1]);

					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						if (office[nx][ny] == 6)
							break;

						if (office[nx][ny] > 0)
							continue;

						office[nx][ny] = val;

					} else
						break;
				}
			}
		}
	}

	private static int calc() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}
}