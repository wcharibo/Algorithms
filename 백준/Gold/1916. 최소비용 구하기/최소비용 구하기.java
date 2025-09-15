import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int dest;
		int fare;
		
		Edge(int dest, int fare){
			this.dest = dest;
			this.fare = fare;
		}

		@Override
		public int compareTo(Edge o) {
			return this.fare - o.fare;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int fare = Integer.parseInt(st.nextToken());
			
			if(map[start][dest] == -1) {
				map[start][dest] = fare;
			}else {
				map[start][dest] = Math.min(map[start][dest], fare);
			}
			
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		int[] distance = new int[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		q.add(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			
			Edge cur = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(map[cur.dest][i] != -1) {
					if(distance[i] > distance[cur.dest] + map[cur.dest][i]) {
						distance[i] = distance[cur.dest] + map[cur.dest][i];
						q.add(new Edge(i, distance[cur.dest] + map[cur.dest][i]));
					}
				}
			}
		}
		
		System.out.println(distance[end]);
	}

}
