import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int C, S, idx;
        Pair(int C, int S, int idx) {
            this.C = C;
            this.S = S;
            this.idx = idx;
        }
    }

    static class SizeComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.S, b.S); // 크기 기준 오름차순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Pair[] balls = new Pair[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            balls[i] = new Pair(C, S, i);
        }

        Arrays.sort(balls, new SizeComparator());

        int[] colorSum = new int[N + 1];
        int[] result = new int[N];
        int totalSum = 0;

        int j = 0;
        for (int i = 0; i < N; i++) {
            Pair cur = balls[i];
            while (balls[j].S < cur.S) {
                totalSum += balls[j].S;
                colorSum[balls[j].C] += balls[j].S;
                j++;
            }
            result[cur.idx] = totalSum - colorSum[cur.C];
        }

        for (int r : result) sb.append(r).append("\n");
        System.out.print(sb);
    }
}
