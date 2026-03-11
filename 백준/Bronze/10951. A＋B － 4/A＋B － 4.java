import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int A = 1;
        int B = 1;
        
        StringTokenizer st;
        String str;
        
        while((str = br.readLine()) != null) {
        	st = new StringTokenizer(str);
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());

        	result.append(A+B).append("\n");
        }
        
        
        System.out.println(result);
        
        
    }
}