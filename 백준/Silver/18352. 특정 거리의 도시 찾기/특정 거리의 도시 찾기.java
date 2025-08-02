import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
		
		ArrayList<Integer>[] cities = new ArrayList[N]; 
		int [] visited = new int[N];
		for(int i = 0; i < N; i++) cities[i] = new ArrayList<Integer>();
		Arrays.fill(visited, -1);
		Queue<Integer> cityQ = new LinkedList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			cities[x].add(y);
		}
		
		visited[X] = 0;
		cityQ.add(X);
		
		while(!cityQ.isEmpty()) {
			int cur = cityQ.poll();
			
			if(!cities[cur].isEmpty()) {
				for(int next : cities[cur]) {
					if(visited[next] == -1) {
						visited[next] = visited[cur] + 1;
						cityQ.add(next);
					}
				}				
			}
		}
		
		for(int i = 0 ; i < visited.length; i++) {
			if(K == visited[i]) result.append(i+1).append("\n");
		}
		
		if(result.length() == 0) result.append(-1);
		
		System.out.println(result);
		
		
	}
}