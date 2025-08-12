import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static int[] operator;
    static long[] arr;

    static long max; static long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            operator = new int[4];
            arr = new long[N];

            max = Long.MIN_VALUE;
            min = Long.MAX_VALUE;
            for (int i = 0; i < str.length; i++) {
                int n = Integer.parseInt(str[i]);
                operator[i] = n;
            }

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(input[i]);
                arr[i] = n;
            }

            for (int i = 0; i < 4; i++) {
                long ret = arr[0];
                if (operator[i] > 0) {
                    operator[i]--;
                    dfs(1, ret, i);
                    operator[i]++;
                }
            }

            long answer = max - min;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int start, long ret, int index) {
        if(index == 0) {
            ret += arr[start];
        } else if(index == 1) {
            ret -= arr[start];
        } else if(index == 2) {
            ret *= arr[start];
        } else if(index == 3) {
            long tmp = Math.round(ret / arr[start]);
            ret = tmp;
        }

        if (start == (N - 1)) {
            max = Math.max(ret, max);
            min = Math.min(ret, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                dfs(start + 1, ret, i);
                operator[i]++;
            }
        }
    }
}
