import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int cnt;
	static int[] dir = { -1, 0, 1 };

	static boolean dfs(int curRow, int curCol) {
		if (curCol == map[0].length -1 ) {
			cnt++;
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int nextRow = curRow + dir[i];
			
			if(0 <= nextRow && nextRow< map.length ) {
				if(!map[nextRow][curCol + 1]) {
					map[nextRow][curCol + 1] = true;
				    if(dfs(nextRow, curCol+1)) return true;
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
		cnt = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j) == 'x') map[i][j] = true;
			}
		}
		
		for(int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		
	
		
		
		System.out.println(cnt);

	}
}