import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[M+1];
		int start = 2;
		
		while(start < M){
		    if(!prime[start]){
    		    int multipleMax = M/start;
    		    
    		    for(int j = 2; j <= multipleMax; j++){
    		        prime[start*j] = true;   
    		    }
		        
		    }
		    
		    start++;
		}
		
		if(N < 2) N = 2;
		
		for(int i = N; i < prime.length; i++) if(!prime[i]) result.append(i).append("\n");
		
		System.out.println(result);
	}
}
