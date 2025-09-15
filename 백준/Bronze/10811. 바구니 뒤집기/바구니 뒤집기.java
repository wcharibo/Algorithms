import java.util.*;
import java.io.*;

public class Main {
	static int books[];
	
	static void swap(int start, int end) {
		while(start < end) {
			int temp = books[start];
			books[start] = books[end];
			books[end] = temp;
			
			start++;
			end--;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		books = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			books[i] = i;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		for(int i = 1; i <= N; i++) sb.append(books[i]).append(" ");
		
		System.out.println(sb);
	}

}
