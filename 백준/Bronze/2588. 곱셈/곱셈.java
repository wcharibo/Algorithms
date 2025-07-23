import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        int a, result = 0;
        String b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = br.readLine();
        
        int[] arrB = new int[3];
        for(int i = 2; i >=0; i--
        		) {
        	arrB[i] = b.charAt(i) - 48;
        	System.out.println(arrB[i]*a);
        }
        int b1 = arrB[0]*100 + arrB[1]*10 + arrB[2];
        
        System.out.println(a*b1);
        
    }
}