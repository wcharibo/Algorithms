import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int[][] boards = new int[T][2];

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boards[t][0] = Integer.parseInt(st.nextToken());
            boards[t][1] = Integer.parseInt(st.nextToken());
        }

        // T가 1일 때 예외 처리 굿
        if(T == 1){
            System.out.println(boards[0][1]);
            return;
        }

        // 정렬 로직 (잘 작성하셨습니다)
        Arrays.sort(boards, (a,b)->{
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // 1. 구간 병합 (Merge Intervals)
        List<int[]> mergeds = new ArrayList<>();
        int start = boards[0][0];
        int end = boards[0][1];

        for(int i = 1; i < T; i++){
            if(end < boards[i][0]){ // 겹치지 않음 (새로운 구간 시작)
                mergeds.add(new int[]{start, end});
                start = boards[i][0];
                end = boards[i][1];
            } else if(boards[i][1] > end){ // 겹치고, 기존 구간보다 더 길게 뻗음
                end = boards[i][1];
            }
            // boards[i][1] <= end 인 경우(포함되는 경우)는 무시 (기존 end 유지)
        }
        mergeds.add(new int[]{start, end}); // 마지막 구간 추가

        // 2. BFS 탐색 (최적화 적용)
        int answer = mergeds.get(0)[1]; // 초기값 설정
        boolean[] vis = new boolean[mergeds.size()];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(0);
        vis[0] = true;

        // 핵심 최적화: 다음에 확인할 인덱스를 기억하는 변수
        int nextIdx = 1; 

        while(!q.isEmpty()){
            int cur = q.poll();
            int[] curInterval = mergeds.get(cur);
            
            // 현재 최대 도달 지점 갱신
            answer = Math.max(answer, curInterval[1]);

            int jump = curInterval[1] - curInterval[0];
            // 오버플로우 방지를 위해 long 사용 권장 (문제 범위에 따라 다름)
            long reachLimit = (long)curInterval[1] + jump; 

            // 최적화: cur + 1이 아니라, '아직 안 본 구간(nextIdx)'부터 확인
            while(nextIdx < mergeds.size()){
                // 정렬되어 있으므로, 현재 점프력으로 닿을 수 없는 구간이 나오면 바로 중단
                if(mergeds.get(nextIdx)[0] > reachLimit) break;
                
                // 닿을 수 있다면 큐에 추가 (vis 체크는 위에서 nextIdx를 증가시키므로 사실상 중복 방문 안 함)
                if(!vis[nextIdx]){
                    vis[nextIdx] = true;
                    q.add(nextIdx);
                }
                nextIdx++; // 다음 인덱스로 이동
            }
        }

        System.out.println(answer);
    }
}