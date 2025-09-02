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

		ArrayList<Pair>[] edges = new ArrayList[N];
		ArrayList<Pair>[] revEdges = new ArrayList[N];		
		
		for(int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
			revEdges[i] = new ArrayList<>();
		}
		int [][] dist = new int[2][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int fare = Integer.parseInt(st.nextToken()) ;
			
			edges[x].add(new Pair(y,fare));
			revEdges[y].add(new Pair(x, fare));
		}

		
		for(int j = 0; j < 2; j++) {
			if(j == 1) {
				edges = revEdges.clone();
				for(int i = 0; i < N; i++) edges[i] = revEdges[i];
			}
			
			int start = X;
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			HashSet<Integer> vist = new HashSet<>();
			
			Arrays.fill(dist[j], 100000);
			dist[j][start] = 0;
			pq.add(new Pair(start, 0));

			
			while(vist.size() != N) {
				Pair cur = pq.poll();
				
				if(!vist.add(cur.target)) continue;
				
				for(Pair next : edges[cur.target]) {
					if(!vist.contains(next.target)) {
						int temp = cur.fare + next.fare;
						if(dist[j][next.target] > temp) {
							dist[j][next.target] = temp;
							pq.add(new Pair(next.target, temp));
						}
					}
				}
			}
		}
		
		
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			result[i] += dist[0][i];
			result[i] += dist[1][i];
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, result[i]);
		}

		System.out.println(max);
	}
}