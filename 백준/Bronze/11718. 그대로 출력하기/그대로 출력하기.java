import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String str;
        
        while((str=br.readLine()) != null) {
        	result.append(str).append("\n");
        }
        
        System.out.println(result);
    }
}