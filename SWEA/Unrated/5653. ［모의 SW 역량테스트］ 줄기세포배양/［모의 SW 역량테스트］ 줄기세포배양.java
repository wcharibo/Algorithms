import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {

	static class Cell {
		int x;
		int y;
		int power;
		int birth;

		public Cell(int x, int y, int power, int birth) {
			this.x = x;
			this.y = y;
			this.power = power;
			this.birth = birth;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.x).append("  ").append(this.y).append("  ").append(this.power).append("  ").append(this.birth);
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 활성화되는 시점 기준 오름차순
			PriorityQueue<Cell> preActive = new PriorityQueue<>((a, b) -> (a.birth + a.power) - (b.birth + b.power));
			// 죽는 시점 기준 오름 차순
			PriorityQueue<Cell> active = new PriorityQueue<>(
					(a, b) -> (a.birth + a.power * 2) - (b.birth + b.power * 2));
			// 죽은 애들 저장
			Queue<Cell> postActive = new ArrayDeque<>();
			// 위치 정보 저장
			HashMap<Point , Cell> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int power = Integer.parseInt(st.nextToken());
					if(power!=0) {
						Cell cur = new Cell(i, j, power, 0);
						preActive.add(cur);
						map.put(new Point(i, j), cur);
					}
				}
			}

			int time = 0;

			while (time != K+1) {
				//1에서 2가 되면서 하는 작업  
				if (!active.isEmpty()) {
					for (Cell cur : active) {
						if (cur.birth + cur.power + 1 == time) {
							for(int i = 0 ; i < 4; i++) {
								int nx = cur.x + dir[i][0];
								int ny = cur.y + dir[i][1];
								Point next = new Point(nx , ny);
								
								Cell child = new Cell(nx, ny, cur.power, time);
								
								if(!map.containsKey(next)) {
									preActive.add(child);
									map.put(next, child);
								}else if(map.containsKey(next) && map.get(next).birth == time  && map.get(next).power < cur.power) {
									Cell replace = map.get(next);
									preActive.remove(replace);
									replace.power = cur.power;
									preActive.add(replace);
								}
								
							}
						}
					}
				}
				// 2가 된 시점의 작업  
				while (!preActive.isEmpty() && preActive.peek().birth + preActive.peek().power == time) {
					active.add(preActive.poll());
				}


				while (!active.isEmpty() && (active.peek().birth + (active.peek().power * 2)) == time) {
					active.poll();
				}
	
				time++;
			}
			
			

			sb.append("#").append(tc).append(" ").append(preActive.size() + active.size()).append("\n");
		}

		System.out.println(sb);
	}
}