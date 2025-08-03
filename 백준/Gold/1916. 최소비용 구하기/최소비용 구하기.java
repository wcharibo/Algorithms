import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static public class Pair {
		Long fare;
		Integer p;

		public Pair(Long fare, Integer p) {
			this.fare = fare;
			this.p = p;
		}

		public Long x() {
			return this.fare;
		}

		public Integer y() {
			return this.p;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] travelCost = new int[N+1][N+1];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>((i,j) -> (int)(i.x() - j.x()));
		boolean[] visited = new boolean[N+1];
		long[] fromStartCost = new long[N+1];
		
		for(int i = 1; i < N+1; i++) Arrays.fill(travelCost[i],	-1);
		Arrays.fill(fromStartCost, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(travelCost[x][y] != -1) travelCost[x][y] = Math.min(travelCost[x][y], cost);
			else travelCost[x][y] = cost;
		}
		
		st = new StringTokenizer(br.readLine());
		int goalStart = Integer.parseInt(st.nextToken());
		int goalEnd = Integer.parseInt(st.nextToken());
		
		fromStartCost[goalStart] = 0;
		
		q.add(new Pair( 0L, goalStart));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			visited[cur.y()] = true;
			
			for(int i = 1; i < travelCost[cur.y()].length; i++) {
				if(travelCost[cur.y()][i] != -1 && !visited[i]) {
					if(fromStartCost[i] > fromStartCost[cur.y()] + travelCost[cur.y()][i]) {
						fromStartCost[i] = fromStartCost[cur.y()] + travelCost[cur.y()][i];
						q.add(new Pair(fromStartCost[cur.y()] + travelCost[cur.y()][i] , i));
					}
				}
			}
			
			
		}
		
		System.out.println(fromStartCost[goalEnd]);
		
	}
}