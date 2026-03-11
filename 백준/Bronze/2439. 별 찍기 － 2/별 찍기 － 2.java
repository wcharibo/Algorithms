import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        
        for(int i = 0, j = N-1 ; i < N; i++, j--) {
        	for(int l = j; l >0; l--) result.append(" ");
        	for(int k = 0; k < i+1; k++) result.append("*");
        	result.append("\n");
        }
        
        
        System.out.println(result); 
    }
}