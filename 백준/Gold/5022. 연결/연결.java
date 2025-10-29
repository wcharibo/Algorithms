import java.io.*;
import java.util.*;

public class Main {

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Edge {
		int c;
		int r;

		Edge(int r, int c) {
			this.c = c;
			this.r = r;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken()) + 1;
		Edge[][] routes = new Edge[M][N];

		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] a1 = new int[] {r, c};
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int[] a2 = new int[] {r, c};
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int[] b1 = new int[] {r, c};
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int[] b2 = new int[] {r, c};

		// a부터 최적경로
		boolean vis[][] = new boolean[M][N];
		Queue<Edge> q = new ArrayDeque<>();
		int aFDist = 0;
		if (bfs(q, vis, routes, a1, a2, b1, b2)) {
			vis = new boolean[routes.length][routes[0].length];
			aFDist += calc(routes, vis, a2);
		}else {
			System.out.println("IMPOSSIBLE");
			return;
		}
		
		vis[b2[0]][b2[1]] = false;
		q.clear();
		for(int i = 0; i < M; i++) {
			Arrays.fill(routes[i], null);
		}
		if (bfs(q, vis, routes, b1, b2, a1, a2)) {
			aFDist += calc(routes, vis, b2);
		}else {
			aFDist = Integer.MIN_VALUE;
		}

		// b부터 최적경로
		for(int i = 0; i < M; i++) {
			Arrays.fill(vis[i], false);
		}
		q.clear();
		int bFDist = 0;
		for(int i = 0; i < M; i++) {
			Arrays.fill(routes[i], null);
		}
		if (bfs(q, vis, routes, b1, b2, a1, a2)) {
			vis = new boolean[routes.length][routes[0].length];
			bFDist += calc(routes, vis, b2);
		}else {
			System.out.println("IMPOSSIBLE");
			return;
		}

		q.clear();
		vis[a1[0]][a1[1]] = false;
		vis[a2[0]][a2[1]] = false;
		for(int i = 0; i < M; i++) {
			Arrays.fill(routes[i], null);
		}
		if (bfs(q, vis, routes, a1, a2, b1, b2)) {
			bFDist += calc(routes, vis, a2);
		}else {
			bFDist = Integer.MIN_VALUE;
		}
		
		if(aFDist != Integer.MIN_VALUE && bFDist != Integer.MIN_VALUE) {
			System.out.println(Math.min(aFDist, bFDist));
		}else if(aFDist != Integer.MIN_VALUE) {
			System.out.println(aFDist);
		}else if(bFDist != Integer.MIN_VALUE) {
			System.out.println(bFDist);
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}

	private static int calc(Edge[][] routes, boolean[][] vis, int[] start) {

		int dist = 0;
		int r = start[0];
		int c = start[1];
		while (routes[r][c].r != -1 && routes[r][c].c != -1) {
			vis[r][c] = true;

			Edge prev = routes[r][c];
			r = prev.r;
			c = prev.c;
			dist++;
		}
		
		return dist;
	}

	private static boolean bfs(Queue<Edge> q, boolean[][] vis, Edge[][] routes, int[] start, int[] goal, int[] o1,
			int[] o2) {
		q.add(new Edge(start[0], start[1]));
		vis[start[0]][start[1]] = true;
		vis[o1[0]][o1[1]] = true;
		vis[o2[0]][o2[1]] = true;
		routes[start[0]][start[1]] = new Edge(-1, -1);

		while (!q.isEmpty()) {
			Edge cur = q.poll();

			if (cur.r == goal[0] && cur.c == goal[1]) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dirs[i][0];
				int nc = cur.c + dirs[i][1];

				if (0 <= nr && nr < routes.length && 0 <= nc && nc < routes[0].length && !vis[nr][nc]) {
					vis[nr][nc] = true;
					routes[nr][nc] = cur;
					q.add(new Edge(nr, nc));
				}
			}
		}

		return false;
	}
}