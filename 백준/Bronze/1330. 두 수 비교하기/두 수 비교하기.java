import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        
        if(a1 < a2) System.out.println("<");
        else if(a1 > a2) System.out.println(">");
        else System.out.println("==");
        
        
        
    }
    
    
}