import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i <=9 ; i++) {
			result.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
		}
		
		System.out.println(result);
	}
}