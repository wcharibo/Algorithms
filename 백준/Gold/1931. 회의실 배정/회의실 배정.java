import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] room = new Point[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			room[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		
		Arrays.sort(room, (a,b)-> {
			if(a.y == b.y) return a.x-b.x;
			else return a.y-b.y;
		});
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			if(q.isEmpty()) {
				q.add(room[i].y);
				cnt++;
				continue;
			}
			
			if(q.peek() <= room[i].x) {
				q.poll();
				q.add(room[i].y);
				
				cnt++;
			}
			
			
		}
		
		
		System.out.println(cnt);
	}
}
