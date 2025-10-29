import java.io.*;
import java.util.*;

public class Main {
	static class Grip{
		int x;
		int y;
		int cnt;
		
		Grip(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		Set<Integer>[] grips = new Set[T + 1];
		Set<Integer>[] grab = new Set[T+1];
		for(int i = 0; i <= T; i++) {
			grips[i] = new HashSet<Integer>();
			grab[i] = new HashSet<Integer>(); 
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			grips[y].add(x);
		}
		
		Queue<Grip> q = new ArrayDeque<>();
		q.add(new Grip(0, 0, 0));
		grab[0].add(0);
		
		while(!q.isEmpty()) {
			Grip cur = q.poll();
			
			if(cur.y == T) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i = -2; i < 3; i++) {
				for(int j = -2; j < 3; j++) {
					if(0 <= cur.y + i && cur.y + i <= T && 0 <= cur.x + j && cur.x + j <= 1000000 && (i!=0 || j!=0)) {
						if(grips[cur.y + i].contains(cur.x + j) && grab[cur.y + i].add(cur.x + j)) {
							q.add(new Grip(cur.x + j, cur.y + i, cur.cnt + 1));
						}
					}
				}
			}			
		}
		
		
		System.out.println(-1);
	}
}