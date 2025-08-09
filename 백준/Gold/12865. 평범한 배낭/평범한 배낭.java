import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] bag = new int[K+1];
		int[][] obj = new int[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			obj[i][0] = Integer.parseInt(st.nextToken());
			obj[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=N; i++) {
			for(int j = K; j-obj[i][0] >=0; j--) {
				bag[j] = Math.max(bag[j], obj[i][1] + bag[j-obj[i][0]]);
			}
		}
		
		System.out.println(bag[K]);
	}
}