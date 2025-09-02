import java.io.*;
import java.util.*;

public class Main {
	static class Pair implements Comparable<Pair>{
		int target;
		int fare;
		
		Pair(int target, int fare){
			this.target = target;
			this.fare = fare;
		}
		
		public int compareTo(Pair latter) {
			return this.fare - latter.fare;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) -1;

		int[][] map = new int[N][N];
		ArrayList<Pair>[] edges = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}
		int [][] dist = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

//			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer
//					.parseInt(st.nextToken());
			
			edges[Integer.parseInt(st.nextToken()) - 1].add(new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}

		
		for(int start = 0; start < N; start++) {

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			HashSet<Integer> vist = new HashSet<>();
			
			vist.add(start);
			Arrays.fill(dist[start], 100000);
			dist[start][start] = 0;
			pq.add(new Pair(start, 0));
			
			while(!pq.isEmpty() && vist.size() != N) {
				Pair cur = pq.poll();

				vist.add(cur.target);
				
//				for(int i = 0; i < N; i++) {
//					if(map[cur.target][i] != 0 && !vist.contains(i)) {
//						int temp = cur.fare + map[cur.target][i];
//						if(dist[start][i] > temp) {
//							dist[start][i] = temp;
//							pq.add(new Pair(i, temp));
//						}
//					}
//				}
				
				for(Pair next : edges[cur.target]) {
					if(!vist.contains(next.target)) {
						int temp = cur.fare + next.fare;
						if(dist[start][next.target] > temp) {
							dist[start][next.target] = temp;
							pq.add(new Pair(next.target, temp));
						}
					}
				}
				
				
			}	
		}
		
		
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			result[i] += dist[i][X];
			result[i] += dist[X][i];
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, result[i]);
		}

		System.out.println(max);
	}
}