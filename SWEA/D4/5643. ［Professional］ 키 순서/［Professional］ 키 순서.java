import java.util.*;
import java.awt.Point;
import java.io.*;

class Solution{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(st.nextToken());
    	
    	for(int tc = 1; tc <= T; tc++) {
    		int answer = 0;
    		int N = Integer.parseInt(br.readLine());
    		int M = Integer.parseInt(br.readLine());
    		int[][] match = new int[N+1][N+1];
    		
    		for(int i = 1; i <= N; i++) {
    			Arrays.fill(match[i],10);
    			match[i][i] = 0;
    		}
    		
    		for(int i = 0; i < M; i++) {
    			st = new StringTokenizer(br.readLine());
    			int win = Integer.parseInt(st.nextToken());
    			int lose = Integer.parseInt(st.nextToken());
    			match[win][lose] = 1;
    			match[lose][win] = -1;		
    		}
    		
    		for(int i = 1; i < N+1; i++){
    	        for(int j = 1; j < N+1; j++){
    	            for(int k = 1; k < N+1; k++){
    	                if(j != i && k != i && j!=k){
    	                    int temp = match[j][i] + match[i][k];
    	                    if(Math.abs(temp) == 2){
    	                        match[j][k] = match[j][i];
    	                    }
    	                }
    	            }
    	        }
    	    }
    		
    		for(int i = 1; i<N+1; i++){
    	        int flag = 0;
    	        for(int j = 1; j<N+1; j++){
    	            if(i != j && Math.abs(match[i][j]) > 2) flag = 1;
    	        }
    	        if(flag == 0) answer++;
    	    }
    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    	}
     
    	System.out.println(sb);
    }
}