



import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		
		String str = st.nextToken();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 97;
			if(arr[idx] == -1) arr[idx] = i; 
		}
		
		for(int i = 0; i < arr.length; i++) result.append(arr[i]).append(" ");
		
		System.out.println(result);
	}
}