import java.util.*;
import java.io.*;

class Main{
    //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C,
    //셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        sb.append((A+B)%C).append("\n");
        sb.append(((A%C) + (B%C))%C).append("\n");
        sb.append((A*B)%C).append("\n");
        sb.append(((A%C) * (B%C))%C).append("\n");
        
        System.out.println(sb);
    }
}