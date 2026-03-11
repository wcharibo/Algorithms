import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] population;
	static int[][] dp;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		tree = new ArrayList[N + 1];
		dp = new int[N + 1][2];
		vis = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			tree[x].add(y);
			tree[y].add(x);
		}

		int[] result = dfs(1);
		int answer = Math.max(result[0], result[1]);
		
		System.out.println(answer);
	}


	private static int[] dfs(int cur) {
		int[] result = new int[2];
		vis[cur] = true;
		result[1] += population[cur];
		
		for(int next : tree[cur]) {
			if(!vis[next]) {
				int[] temp = dfs(next);
				result[0] += Math.max(temp[1], temp[0]);
				result[1] += temp[0];
			}
		}
		
		return result;
	}
}