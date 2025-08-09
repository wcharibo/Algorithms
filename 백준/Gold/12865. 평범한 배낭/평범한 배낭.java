import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		int[][] bag = new int[N+1][K+1];
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=N; i++) {
			for(int j = 1; j <= K; j++) {
				if(weight[i] <= j) {
					if(value[i] + bag[i-1][j-weight[i]] > bag[i-1][j]) {
						bag[i][j] = value[i] + bag[i-1][j-weight[i]];
					}else {
						bag[i][j] = bag[i-1][j];
					}
				}else {
					bag[i][j] = bag[i-1][j];
				}
				max = Math.max(max, bag[i][j]);
			}
		}
		
		System.out.println(max);
	}
}