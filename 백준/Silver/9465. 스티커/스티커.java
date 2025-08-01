import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < test; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][3];
			int [] maxSum = new int[3];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxSum[0] = arr[0][0];
			maxSum[1] = arr[0][1];
			maxSum[2] = arr[0][2];
			
			for(int i = 1; i < N; i++) {
				int max0 = maxSum[0], max1 = maxSum[1], max2 = maxSum[2];
				maxSum[0] = Math.max(max1 + arr[i][0], max2 + arr[i][0]);
				maxSum[1] = Math.max(max0 + arr[i][1], max2 + arr[i][1]);
				maxSum[2] = Math.max(max0 + arr[i][2], max1 + arr[i][2]);
			}
			
			int max = Math.max(maxSum[0], Math.max( maxSum[1], maxSum[2]));
			System.out.println(max);
		}
	}
}