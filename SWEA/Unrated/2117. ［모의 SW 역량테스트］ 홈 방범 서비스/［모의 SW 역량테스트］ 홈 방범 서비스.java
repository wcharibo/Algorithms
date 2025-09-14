import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {
	static int calculate(int i) {
		return i*i + (i-1) * (i-1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[N][N];
			ArrayList<Point> homes = new ArrayList<Point>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = 1 == Integer.parseInt(st.nextToken());
					if(map[i][j]) {
						homes.add(new Point(i,j));
					}
				}
			}
			
			int result = 1;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					for(int k = 1; k <= N + 1; k++) {
						int homeCnt = 0;
						
						for(Point home : homes) {
							if(Math.abs(i - home.x) + Math.abs(j - home.y) < k) {
								homeCnt++;
							}
						}
						
						int cost = calculate(k);
						int revenue = homeCnt * M;
						
						if(revenue >= cost) {
							result = Math.max(result, homeCnt);
						}
					}
				}
			}
			

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		

		System.out.println(sb);
	}
}