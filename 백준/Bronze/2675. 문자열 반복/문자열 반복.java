



import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int recur = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int j = 0; j < str.length(); j++) {
				char temp = str.charAt(j);
				for(int k = 0; k < recur; k++) {
					result.append(temp);
				}
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}
}