


import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
//		int total = Integer.parseInt(st.nextToken());
		
//		int result = 0;
		int N = Integer.parseInt(st.nextToken());
//		int target = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
//		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N ; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a < min) min = a;
			if(a > max) max = a;
		}
		
		result.append(min).append(" ").append(max);
		
		System.out.println(result);
	}
}