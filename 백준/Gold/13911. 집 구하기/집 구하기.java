import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static class Pair implements Comparable<Pair>{
		int dest;
		int fare;

		public Pair(int dest, int fare) {
			this.dest = dest;
			this.fare = fare;
		}
		
		public int compareTo(Pair n) {
			return this.fare - n.fare;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Pair>[] map = new ArrayList[V + 2];
		for (int i = 1; i <= V + 1; i++)
			map[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			map[s].add(new Pair(e, f));
			map[e].add(new Pair(s, f));
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		int mc = Integer.parseInt(st.nextToken());
		int mcMax = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < mc; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			map[V + 1].add(new Pair(temp, 0));
		}
		st = new StringTokenizer(br.readLine());
		
		//맥도
		int[] distM = new int[V+2];
		Arrays.fill(distM, Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(); 
		pq.add(new Pair(V+1, 0));
		
		while(!pq.isEmpty()) {
			int e = pq.peek().dest;
			int fare = pq.poll().fare;
			
			distM[e] = Math.min(distM[e], fare);
			
			for(Pair pos : map[e]) {
				if(fare + pos.fare <= mcMax && distM[pos.dest] > fare + pos.fare) {
					distM[pos.dest] = fare + pos.fare;
					pq.add(new Pair(pos.dest, distM[pos.dest]));
				}
			}
		}
		
		map[V+1].clear();
		//스벅
		int star = Integer.parseInt(st.nextToken());
		int starMax = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < star; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			map[V+1].add(new Pair(temp, 0));
		}
		
		int[] distS = new int[V+2];
		Arrays.fill(distS, Integer.MAX_VALUE);
		
		pq = new PriorityQueue<>();
		pq.add(new Pair(V+1, 0));
		
		while(!pq.isEmpty()) {
			int e = pq.peek().dest;
			int fare = pq.poll().fare;
			
			distS[e] = Math.min(distS[e], fare);
			
			for(Pair pos : map[e]) {
				if(fare + pos.fare <= starMax && distS[pos.dest] > fare + pos.fare) {
					distS[pos.dest] = fare + pos.fare;
					pq.add(new Pair(pos.dest, distS[pos.dest]));
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 1; i <= V; i++) {
			result = (distM[i] == 0 || distS[i] == 0 || distM[i] == Integer.MAX_VALUE || distS[i] == Integer.MAX_VALUE) ? result : Math.min(result, distM[i] + distS[i]);
		}
		
		
//		System.out.println(Arrays.toString(distM));
//		System.out.println(Arrays.toString(distS));

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}