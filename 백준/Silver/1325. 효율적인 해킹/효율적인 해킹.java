import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] com = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) com[i] = new ArrayList<>();
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int trust = Integer.parseInt(st.nextToken());
			int hacked = Integer.parseInt(st.nextToken());
			com[hacked].add(trust);
		}
		
		int[] fellow = new int[N+1];
		Arrays.fill(fellow, -1);
		int max = -1;
		
		
		for(int i = 1; i <= N; i++) {
			boolean[] vis = new boolean[N+1];
			Queue<Integer> q = new LinkedList<>();
			
			q.add(i);
			vis[i] = true;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int j : com[cur]) {
					if(!vis[j]) {
						vis[j]=true;
						q.add(j);
					}
				}
			}
			
			for(int j = 1; j <= N; j++) if(vis[j]) fellow[i]++;
			max = Math.max(max, fellow[i]);
		}
		
		for(int i = 1; i <= N; i++) if(max == fellow[i]) sb.append(i).append(" ");
		
		System.out.println(sb);
	}
}