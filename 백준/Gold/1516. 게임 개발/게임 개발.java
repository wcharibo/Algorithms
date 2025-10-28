//최대값만 저장하는 풀이 384ms 
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] buildTime = new int[N];
		int[] posts = new int[N];
		List<Integer>[] prevs = new ArrayList[N];
		Queue<Integer> q = new ArrayDeque<>();
		int[] prevBuildTime = new int[N];
		
		for(int i = 0; i < N; i++) {
			prevs[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			buildTime[i] = Integer.parseInt(st.nextToken());
			
			int j;
			while((j = Integer.parseInt(st.nextToken())) != -1) {
				int prev = j - 1;
				
				prevs[prev].add(i);
				posts[i]++;
			}
			
			if(posts[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			
			for(int i : prevs[idx]) {
				if(--posts[i] >= 0) {
					prevBuildTime[i] = Math.max(prevBuildTime[i], buildTime[idx]);
					if(posts[i] == 0) {
						q.add(i);
						buildTime[i] += prevBuildTime[i];
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(buildTime[i]);
		}
		
	}
}