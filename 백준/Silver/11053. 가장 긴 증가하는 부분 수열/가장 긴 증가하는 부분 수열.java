import java.util.*;
import java.io.*;

public class Main {
	static int find(int cur, int[] arr, int[] lis) {
		int max = 0;
		
		for(int i = 0; i < cur; i++) {
			if(arr[cur] > arr[i]) {
				max = Math.max(lis[i]+1, max);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int result = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] lis = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			lis[i] = find(i, arr, lis);
		}

		for(int i = 0; i < N; i++) {
			result = Math.max(result, lis[i]);
		}
//		System.out.println(Arrays.toString(lis));
		
		System.out.println(result+1);
	}
}
