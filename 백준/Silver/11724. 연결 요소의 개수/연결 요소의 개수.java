import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		graph = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		visited = new boolean[N + 1];
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			visited[current] = true;
			
			for(int i = 0; i < graph[current].size(); i++) {
				int next = graph[current].get(i);
				if(!visited[next])
				{
					q.add(next);
					visited[next] = true;
				}
					
			}
		}
	}
}
