import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int sizeA = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> numA = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < sizeA; i++) numA.put(Integer.parseInt(st.nextToken()), 1);
		
		int sizeM = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < sizeM; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(numA.containsKey(temp)) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
			
		System.out.println(sb);
	}
}
