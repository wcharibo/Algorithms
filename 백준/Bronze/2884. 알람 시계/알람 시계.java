import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        minute -= 45;
        if (minute < 0) {
            minute += 60;
            hour--;
            if (hour < 0) hour = 23;
        }
        
        System.out.println(hour + " " + minute);
    }
}