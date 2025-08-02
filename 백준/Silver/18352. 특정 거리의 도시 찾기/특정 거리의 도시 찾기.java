import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		final int X = Integer.parseInt(st.nextToken()) - 1;
		
//		boolean[][] cities = new boolean[N][N];
		HashMap<Integer, ArrayList<Integer>> cities = new HashMap<>(); 
		int [] visited = new int[N];
		Arrays.fill(visited, Integer.MAX_VALUE);
		Queue<Point> cityQ = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
//			if(cities.computeIfAbsent(x, k -> new ArrayList<>()).add(y)) cities.get(x).add(y);
			cities.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
			
		}
		
		visited[X] = 0;
		for(int y : cities.get(X)) {
			if(visited[y] == Integer.MAX_VALUE) cityQ.add(new Point(X, y));
		}
		
		while(!cityQ.isEmpty()) {
			Point cur = cityQ.poll();
			
			visited[cur.y] = Math.min(visited[cur.x] + 1, visited[cur.y]);
			
			if(cities.containsKey(cur.y))
				for(int next : cities.get(cur.y)) 
					if(visited[next] == Integer.MAX_VALUE) cityQ.add(new Point(cur.y, next));		
			
		}
		
		for(int i = 0 ; i < visited.length; i++) {
			if(K == visited[i]) result.append(i+1).append("\n");
		}
		
		if(result.length() == 0) result.append(-1);
		
		System.out.println(result);
		
		
	}
}