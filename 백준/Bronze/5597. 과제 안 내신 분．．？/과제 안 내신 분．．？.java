



import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
//		int total = Integer.parseInt(st.nextToken());
//		int result = 0;
//		int N = Integer.parseInt(st.nextToken());
//		int target = Integer.parseInt(st.nextToken());
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
		int total = 30;
		int N = 28;
		
		
		boolean[] arr = new boolean[total];

		for(int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int done = Integer.parseInt(st.nextToken()) - 1;
			
			arr[done] = true;
		}
		
		for(int i = 0; i < total; i++) if(!arr[i]) result.append(i+1).append("\n");
		
		System.out.println(result);
	}
}