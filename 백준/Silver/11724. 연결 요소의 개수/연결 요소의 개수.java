
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList[] connection;
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		visited = new boolean[N + 1];
		visited[0] = true;

		connection = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			connection[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			connection[start].add(end);
			connection[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				result++;
			}
		}

		System.out.println(result);
	}

	static void dfs(int i) {
		visited[i] = true;
		for (int j = 0; j < connection[i].size(); j++) {
			int cur = (int)connection[i].get(j);
			if (!visited[cur]) dfs(cur);
		}
	}

}
