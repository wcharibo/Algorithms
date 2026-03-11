
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder result = new StringBuilder();
		int total = Integer.parseInt(st.nextToken());
		
		String answer = "";
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		for(int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			result += (price*num);
		}
		
		if(result == total) answer+= "Yes";
		else answer+="No";
		
		System.out.println(answer);
	}
}