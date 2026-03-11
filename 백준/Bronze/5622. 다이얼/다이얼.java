import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder result = new StringBuilder();
        int arr[] = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,6,7,7,7,8,8,8,8};
        
        
        int  result = 0;
        
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++) {
        	result += (arr[str.charAt(i) - 65] + 2);
        }
        
        System.out.println(result);
        
    }
}