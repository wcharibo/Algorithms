import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int result = 0;
		
		boolean[][] friends = new boolean[n+1][n+1];
		int[] dist = new int[n+1];
		Queue<Integer> que = new LinkedList<>();
		
		Arrays.fill(dist, 10);

		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			friends[x][y] = true;
			friends[y][x] = true;
		}
		
		que.add(1);
		dist[1] = 0;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			if(dist[cur] >= 2) continue;
			
			for(int i = 1; i < friends[cur].length; i++) {
				if(friends[cur][i]) {
					if(dist[i] > dist[cur] + 1) {
						dist[i] = dist[cur] + 1;
						que.add(i);
					}
				}
			}
		}
		
		for(int i = 2; i < n+1; i++) if(dist[i]<3) result++;
		
		System.out.println(result);
	}
}