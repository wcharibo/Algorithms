import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        boolean[] exist = new boolean[2000001]; // [-1000000, 1000000] → [0, 2000000]

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            exist[num + 1000000] = true;
        }

        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.print(sb);
    }
}