import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Point> cores;
	static int N, cnt, maxCnt, minLines, lines;
	
	public static boolean possible(int row, int col, int dirIdx) {
		
		for(int i = 1; i < N; i++) {
			int nextRow = row + directions[dirIdx][0]*i;
			int nextCol = col + directions[dirIdx][1]*i;
			
			if(0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N && map[nextRow][nextCol] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void fill(int row, int col, int dirIdx) {
		for(int i = 1; i < N; i++) {
			int nextRow = row + directions[dirIdx][0]*i;
			int nextCol = col + directions[dirIdx][1]*i;
			
			if(0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
				map[nextRow][nextCol] = 1;
				lines++;
			}
		}
	}
	
	public static void restore(int row, int col, int dirIdx) {
		for(int i = 1; i < N; i++) {
			int nextRow = row + directions[dirIdx][0]*i;
			int nextCol = col + directions[dirIdx][1]*i;
			
			if(0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
				map[nextRow][nextCol] = 0;
				lines--;
			}
		}
	}

	public static void dfs(int curIdx) {
		
		if (maxCnt > cores.size() - curIdx + cnt)
			return;
		
		if(curIdx == cores.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minLines = lines;
			}
			if(maxCnt == cnt) minLines = Math.min(minLines, lines);
			
			return;
		}
		
		Point curCore = cores.get(curIdx);
		// dirIdx : 0 - up, 1 - down, 2 - left, 3 - right
		for(int dirIdx = 0; dirIdx < 4; dirIdx++) {
			if (possible(curCore.x, curCore.y, dirIdx)) {
				fill(curCore.x, curCore.y, dirIdx);
				cnt++;
				dfs(curIdx + 1);
				restore(curCore.x, curCore.y, dirIdx);
				cnt--;
			}
		}

		// none
		dfs(curIdx + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			cnt = 0;
			lines = 0;
			maxCnt = 0;
			minLines = 0;
			cores = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
					if (input == 1 && i != 0 && j != 0)
						cores.add(new Point(i, j));
				}
			}

			dfs(0);

			sb.append("#").append(tc).append(" ").append(minLines).append("\n");
		}
		System.out.println(sb);
	}
}