import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder result = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int result = 0;
		
		
		for(int i = 1; i <= N ; i++) {
			result+=i;
		}
		
		System.out.println(result);
	}
}