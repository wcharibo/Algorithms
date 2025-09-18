import java.io.*;
import java.util.*;

public class Main {
	static class MovingObject {
		boolean fire;
		int r;
		int c;
		int dist;

		MovingObject(boolean fire, int x, int y) {
			this.fire = fire;
			this.r = x;
			this.c = y;
		}
		
		MovingObject(boolean fire, int x, int y, int dist) {
			this.fire = fire;
			this.r = x;
			this.c = y;
			this.dist = dist;
		}
		
		Pair getPair() {
			return new Pair(this.r, this.c);
		}
	}
	
	static class Pair{
		int r;
		int c;
		
		Pair(int x, int y){
			this.r = x;
			this.c = y;
		}
		
		int x() {
			return this.r;
		}
		
		int y() {
			return this.c;
		}
		
		@Override
	    public boolean equals(Object obj) {
			Pair other = (Pair) obj;
	        return this.r == other.r && this.c == other.c;
	    }
		
		@Override
		public int hashCode() {
			return Objects.hash(r,c);
		}
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Set<Pair> exits = new HashSet<>();
		Queue<MovingObject> q = new ArrayDeque<>();
		MovingObject start = null;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '#') {
					map[i][j] = -1;
				} else if (str.charAt(j) == 'F') {
					q.add(new MovingObject(true, i, j));
					map[i][j] = -1;
				} else if (str.charAt(j) == 'J') {
					start = new MovingObject(false, i, j, 0);
					if(i==0 || j ==0 || i == R-1 || j == C-1) {
						exits.add(new Pair(i,j));
					}
				} else if(i==0 || j ==0 || i == R-1 || j == C-1) {
					exits.add(new Pair(i,j));
				}
			}
		}

		q.add(start);

		while (!q.isEmpty()) {
			MovingObject cur = q.poll();
			
			if(!cur.fire) {
				
				if(exits.contains(new Pair(cur.r, cur.c))){
					System.out.println(cur.dist +1);
					return;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dirs[i][0];
				int nc = cur.c + dirs[i][1];
				
				if(0 <= nr && nr < R && 0 <= nc && nc < C) {
					if(cur.fire && map[nr][nc] >= 0) {
						q.add(new MovingObject( cur.fire, nr, nc));
						map[nr][nc] = -1;
					}else if(!cur.fire && map[nr][nc] == 0) {
						map[nr][nc] = cur.dist + 1;
						q.add(new MovingObject(cur.fire, nr, nc , map[nr][nc]));
					}
				}
			}
			
		}
		
//		for(Pair i : exits) {
//			System.out.println(i.r + " " + i.c);
//		}
//		
//		for(int i = 0 ; i < R ; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		System.out.println("IMPOSSIBLE");
	}
}