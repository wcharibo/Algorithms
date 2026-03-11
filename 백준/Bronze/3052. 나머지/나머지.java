


import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder result = new StringBuilder();
//		int total = Integer.parseInt(st.nextToken());
		int result = 0;
//		int N = Integer.parseInt(st.nextToken());
//		int target = Integer.parseInt(st.nextToken());
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
		int total = 10;
		int N = 42;
		
		
		int[] arr = new int[N];

		for(int i = 0; i < total ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())%42]++;
		}
		
		for(int i = 0; i < N; i++) if(arr[i] > 0) result++;
	
		
		System.out.println(result);
	}
}