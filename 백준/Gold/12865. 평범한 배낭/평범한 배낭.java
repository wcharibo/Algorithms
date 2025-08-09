import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		int[] bag = new int[K+1];
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=N; i++) {
			for(int j = K; j-weight[i] >=0; j--) {
				bag[j] = Math.max(bag[j], value[i] + bag[j-weight[i]]);
			}
		}
		
		System.out.println(bag[K]);
	}
}