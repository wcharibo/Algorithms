import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int f;
		
		Edge(int a, int b, int f){
			this.a = a;
			this.b = b;
			this.f = f;
		}
		
		@Override
		public int compareTo(Main.Edge o) {
			return this.f - o.f;
		}
	}
	
	static int[] sets;
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		
		sets[pb] = pa;
		
		return true;
	}
	
	private static int find(int a) {
		if(sets[a] == a) return a;
		
		return sets[a] = find(sets[a]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sets = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			sets[i%(N+1)] = i%(N+1);
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(a,b,f));
		}
		
		for(int i = M; i <= N; i++) sets[i] = i;
		
		int unionCnt = 0;
		int maxFareRoad = 0;
		int fares = 0;
		
		while(unionCnt < N && !pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(union(cur.a, cur.b)) {
				unionCnt++;
				fares += cur.f;
				maxFareRoad = Math.max(maxFareRoad, cur.f);
			}
			
		}
		
		System.out.println(fares - maxFareRoad);
	}

}