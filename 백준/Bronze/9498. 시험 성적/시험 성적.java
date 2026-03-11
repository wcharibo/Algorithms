import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st  = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(br.readLine());
        
        if(100 >= a && a >=90) System.out.println("A");
        else if(89>=a && a >=80) System.out.println("B");
        else if(79 >= a && a >= 70) System.out.println("C");
        else if(69 >= a && a >= 60) System.out.println("D");
        else System.out.println("F");
        
        
        
    }
    
    
}