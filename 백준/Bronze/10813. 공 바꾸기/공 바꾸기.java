



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
		int throwNum = Integer.parseInt(st.nextToken());;
//		int target = Integer.parseInt(st.nextToken());
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = i+1;
//		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < throwNum ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int temp = arr[start-1];
			arr[start-1] = arr[end-1];
			arr[end-1] = temp;
			
		}
		
		for(int i = 0; i < N; i++) result.append(arr[i]).append(" ");
		
		System.out.println(result);
	}
}