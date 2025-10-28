import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] start, goal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = new int[N];
        goal = new int[N];

        String startStr = br.readLine();
        String goalStr = br.readLine();
        for (int i = 0; i < N; i++) {
            start[i] = startStr.charAt(i) - '0';
            goal[i] = goalStr.charAt(i) - '0';
        }

        int res1 = simulate(false);
        int res2 = simulate(true);

        int ans = Math.min(res1, res2);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int simulate(boolean firstSwitch) {
        int[] temp = Arrays.copyOf(start, N);
        int cnt = 0;

        if (firstSwitch) {
            toggle(temp, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (temp[i - 1] != goal[i - 1]) {
                toggle(temp, i);
                cnt++;
            }
        }

        return Arrays.equals(temp, goal) ? cnt : Integer.MAX_VALUE;
    }

    static void toggle(int[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) arr[i] ^= 1;
        }
    }
}
