import java.io.*;
import java.util.*;

public class Main {
    // 8방향 이동을 위한 배열
    static short[][] dirs = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
            { -1, 1 } };
    static short maxAte = 0;
    static final short N = 4;
    static final short n = (short)(N * N);  // N*N을 short로 계산

    // 물고기 클래스
    static class Fish {
        short fishNum;
        short dir;
        boolean ate = false;

        Fish(short fishNum, short dir) {
            this.fishNum = fishNum;
            this.dir = dir;
        }

        Fish(short fishNum, short dir, boolean ate) {
            this.fishNum = fishNum;
            this.dir = dir;
            this.ate = ate;
        }
    }

    // 상어 클래스
    static class Jaws {
        Fish[][] curFishes;
        short ate;
        short row;
        short col;
        short dir = 0;
        short[][] order;

        Jaws(short ate, Fish[][] curFishes, short row, short col, short[][] order) {
            this.ate = ate;
            this.curFishes = curFishes;
            this.row = row;
            this.col = col;
            this.order = order;
        }

        Jaws(short ate, Fish[][] curFishes, short row, short col, short dir, short[][] order) {
            this.ate = ate;
            this.curFishes = curFishes;
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.order = order;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] fishes = new Fish[N][N];
        short[][] order = new short[n + 1][2];  // fishNum에 맞는 위치 배열

        // 입력 받기
        for (short i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (short j = 0; j < N; j++) {
                short fishNum = Short.parseShort(st.nextToken());
                short dir = Short.parseShort(st.nextToken());
                fishes[i][j] = new Fish(fishNum, dir);
                order[fishNum][0] = i;
                order[fishNum][1] = j;
            }
        }

        Queue<Jaws> q = new ArrayDeque<>();
        q.add(new Jaws((short)0, fishes, (short)0, (short)0, order));

        while (!q.isEmpty()) {
            Jaws cur = q.poll();
            
            cur.ate += cur.curFishes[cur.row][cur.col].fishNum;
            cur.dir = cur.curFishes[cur.row][cur.col].dir;
            cur.curFishes[cur.row][cur.col].ate = true;

            maxAte = (short)Math.max(maxAte, cur.ate);

            fishMove(cur.curFishes, cur, cur.order);

            // 상어가 먹을 수 있는 곳을 탐색
            for (short i = 1; i < N; i++) {
                short nr = (short)(cur.row + i * dirs[cur.dir][0]);
                short nc = (short)(cur.col + i * dirs[cur.dir][1]);

                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    if (!cur.curFishes[nr][nc].ate) {
                        Jaws next = deepCopy(cur);
                        next.row = nr;
                        next.col = nc;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(maxAte);
    }

    // 물고기 이동 함수
    private static void fishMove(Fish[][] curFishes, Jaws jaws, short[][] order) {
        for (short k = 1; k <= n; k++) {
            short i = order[k][0];
            short j = order[k][1];

            if (i == jaws.row && j == jaws.col)
                continue;
            if (curFishes[i][j].ate)
                continue;

            short nextDir = curFishes[i][j].dir;
            do {
                short nr = (short)(i + dirs[nextDir][0]);
                short nc = (short)(j + dirs[nextDir][1]);

                if (0 <= nr && nr < N && 0 <= nc && nc < N && !(nr == jaws.row && nc == jaws.col)) {
                    order[curFishes[i][j].fishNum][0] = nr;
                    order[curFishes[i][j].fishNum][1] = nc;
                    order[curFishes[nr][nc].fishNum][0] = i;
                    order[curFishes[nr][nc].fishNum][1] = j;

                    Fish temp = curFishes[i][j];
                    temp.dir = nextDir;
                    curFishes[i][j] = curFishes[nr][nc];
                    curFishes[nr][nc] = temp;

                    break;
                }

                nextDir++;
                nextDir = nextDir > 8 ? (short)(nextDir - 8) : nextDir;
            } while (nextDir != curFishes[i][j].dir);
        }
    }

    // 깊은 복사 함수
    static public Jaws deepCopy(Jaws p) {
        Fish[][] nf = new Fish[N][N];
        short[][] newO = new short[n + 1][2];
        for (short i = 0; i < N; i++) {
            for (short j = 0; j < N; j++) {
                Fish tempFish = new Fish(p.curFishes[i][j].fishNum, p.curFishes[i][j].dir, p.curFishes[i][j].ate);
                nf[i][j] = tempFish;
            }
        }
        for (short i = 1; i <= n; i++) {
            newO[i][0] = p.order[i][0];
            newO[i][1] = p.order[i][1];
        }

        return new Jaws(p.ate, nf, p.row, p.col, p.dir, newO);
    }
}
