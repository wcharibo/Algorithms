



import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder result = new StringBuilder();
		
		String a = st.nextToken();
		int b = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		System.out.println(a.charAt(b-1));
	}
}