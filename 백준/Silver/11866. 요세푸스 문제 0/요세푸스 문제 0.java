import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> joseph = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 1 ; i <= N ; i++ ) joseph.add(i);
        
        int cnt = 1;
        while(!joseph.isEmpty()) {
        	int cur = joseph.poll();
        	
        	if(cnt == K) {
        		result.add(cur);
        		cnt = 1;
        		continue;
        	}
        	else {
        		joseph.add(cur);
        		cnt++;
        	}
        }
        
        sb.append("<");
        for(int i : result) sb.append(i).append(", ");
        sb.deleteCharAt(sb.toString().length()-1);
        sb.deleteCharAt(sb.toString().length()-1);
        sb.append(">");
        
        System.out.println(sb);
        
    }
}