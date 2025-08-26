import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
	
	static int[] root;
	
	static int find(int x){
		if(root[x] == x) return root[x];
		return root[x] = find(root[x]);
	}
	
	static boolean union(int x, int y) {
		int pX = find(x);
		int pY = find(y);
		
		if(pX == pY) return false;
		
		root[pY] = pX;
		
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int fare;
		
		Edge(int start, int end, int fare){
			this.start = start;
			this.end = end;
			this.fare = fare;
		}
		
		@Override
		public int compareTo(Edge edge) {
			return Integer.compare(this.fare, edge.fare);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int T = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//
//		for (int tc = 1; tc <= T; tc++) {
//			
//			sb.append("#").append(tc).append(" ").append(cnt - mineCnt).append("\n");
//
//		}
//		System.out.println(sb);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int unionCnt = 0;
		root = new int[V+1];
		PriorityQueue<Edge> edges = new PriorityQueue<>();
//		Edge[] edges = new Edge[E];
		
		for(int i = 1; i <= V; i++) root[i] = i;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int fare = Integer.parseInt(st.nextToken());
				
			edges.add(new Edge(start, end, fare));
		}
		
		while(unionCnt < V && !edges.isEmpty()) {
			Edge cur = edges.poll();
			if(unionCnt < V && union(cur.start, cur.end)) {
				cnt+=cur.fare;
				unionCnt++;
			}
		}
		
		
		System.out.println(cnt);
		
	}
}