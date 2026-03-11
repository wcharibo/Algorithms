import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		int max = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		boolean a01 = arr[0]==arr[1];
		boolean a02 = arr[0]==arr[2];
		boolean a12 = arr[1]==arr[2];
		int result = 0;
		
		if(a01 & a02 & a12) result+=(10000+arr[0]*1000); 
		else if(a01) result+=(1000+arr[0]*100);
		else if(a02) result+=(1000+arr[0]*100);
		else if(a12) result+=(1000+arr[1]*100);
		else result+=(max*100);
		
		System.out.println(result);
	}
}