

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder result = new StringBuilder();
		
//		String n1 = st.nextToken();
//		String n2 = st.nextToken();
//		
//		StringBuilder temp = new StringBuilder();
//		temp.append(n1.charAt(2)).append(n1.charAt(1)).append(n1.charAt(0));
//		String n1b = temp.toString();
//		
//		
//		temp = new StringBuilder();
//		temp.append(n2.charAt(2)).append(n2.charAt(1)).append(n2.charAt(0));
//		String n2b = temp.toString();
//		
//		if(Integer.parseInt(n1b) < Integer.parseInt(n2b)) result.append(n2b);
//		else result.append(n1b);
		
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		int result = Math.max(a, b);
		
		System.out.println(result);
	}
}