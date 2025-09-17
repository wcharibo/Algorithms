import java.util.*;
import java.io.*;
import java.awt.Point;

class Main {
	// 가로, 세로, 대각 
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	// 벽을 저장할 배열
	static int[][] map;
	static int result;
	static int N;

	static int dfs(Point start, Point end) {
		if (end.x == N && end.y == N) 
			return ++result;

		
		int dirX = end.x - start.x;
		int dirY = end.y - start.y;

		for (int i = 0; i < dirs.length; i++) {
			if(dirX == dirs[i][0] || dirY == dirs[i][1]) {
				if(end.x + dirs[i][0] <= N && end.y + dirs[i][1] <= N) {				
					if (checkDir(new Point(dirs[i][0], dirs[i][1]), end)) {
						dfs(end, new Point(end.x + dirs[i][0], end.y + dirs[i][1]));
					}
				}
				
			}
		}

		return 0;
	}
	
	static boolean checkDir(Point dir ,Point end) {
		if(dir.x == 1 && dir.y == 1) {
			return checkCross(end);
		}else if(dir.x == 1) {
			return checkHierachy(end);
		}else return checkPararell(end);
	}

	static boolean checkCross(Point end) {
		for (int i = 0; i < dirs.length; i++) {
			if (map[end.x + dirs[i][0]][end.y + dirs[i][1]] == 1)
				return false;
		}
		return true;
	}

	static boolean checkPararell(Point end) {
		return map[end.x + dirs[0][0]][end.y + dirs[0][1]] == 1 ? false : true;
	}

	static boolean checkHierachy(Point end) {
		return map[end.x + dirs[1][0]][end.y + dirs[1][1]] == 1 ? false : true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		result = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new Point(1, 1), new Point(1, 2));

		System.out.println(result);
	}
}