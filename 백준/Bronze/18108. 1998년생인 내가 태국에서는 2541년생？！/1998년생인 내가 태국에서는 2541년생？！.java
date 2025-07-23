import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int diff = 2541-1998;
        
        int a = Integer.parseInt(st.nextToken());
        
        sb.append(a-diff);
        System.out.println(sb);
    }
}