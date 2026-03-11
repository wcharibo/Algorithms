import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st  = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        if(x > 0 && y > 0) System.out.println(1);
        else if(x > 0 && y < 0) System.out.println(4);
        else if(x < 0 && y < 0) System.out.println(3);
        else System.out.println(2);
        
    }
    
    
}