import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] edges;
	static int[] roots;
	
	static void connect(int cur) {
		for(int i = 0; i < edges[cur].size(); i++) {
			if(roots[edges[cur].get(i)] != 0) {
				roots[cur] = edges[cur].get(i);
			}
			else {
				roots[edges[cur].get(i)] = cur;
				connect(edges[cur].get(i));
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N+1];
		roots = new int[N+1];
		
		roots[1] = 1;
		
		for(int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		connect(1);
		
		for(int i = 2; i < roots.length; i++) {
			sb.append(roots[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
