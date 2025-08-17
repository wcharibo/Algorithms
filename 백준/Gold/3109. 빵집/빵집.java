import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int[] dir = { -1, 0, 1 };

	static boolean dfs(int curRow, int curCol) {
		if (curCol == map[0].length -1 ) {
			return true;
		}
		
		
		for(int i = 0; i < 3; i++) {
			int nextRow = curRow + dir[i];
			
			boolean flag = false;
			
			if(0 <= nextRow && nextRow< map.length ) {
				if(!map[nextRow][curCol + 1]) {
					map[nextRow][curCol + 1] = true;
					flag = dfs(nextRow, curCol + 1);
					if(flag) return flag;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == 'x') map[i][j] = true;
			}
		}
		
		for(int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			if(map[i][C-1]) cnt++;
		}
		
		System.out.println(cnt);

	}
}