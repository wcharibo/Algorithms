import java.util.*;
import java.io.*;

public class Solution {
	static ArrayList<Person> people;
	static ArrayList<int[]> stairs;
	static Queue<Person>[] curStair;
	static int[] stairSelection;
	static int result;

	static class Person implements Comparable<Person> {
		int cx;
		int cy;
		int avt;
		int outT;

		public Person(int cx, int cy) {
			this.cx = cx;
			this.cy = cy;
		}

		void setArriveTime(int i) {
			this.avt = Math.abs(stairs.get(i)[1] - cx) + Math.abs(stairs.get(i)[2] - cy);
		}

		void setOutTime(int start, int stairIdx) {
			this.outT = start + stairs.get(stairIdx)[0];
		}

		@Override
		public int compareTo(Person latter) {
			return this.avt - latter.avt;
		}
	}

	static void make(int cur) {
		if (cur == people.size()) {

			result = Math.min(result, calculate());
//			System.out.println("--------------");
//			System.out.println(result);
//			System.out.println();
			return;
		}

		stairSelection[cur] = 1;
		make(cur + 1);
		stairSelection[cur] = 0;
		make(cur + 1);
	}

	static int calculate() {
		PriorityQueue<Person>[] stairList = new PriorityQueue[2];
		stairList[0] = new PriorityQueue<>();
		stairList[1] = new PriorityQueue<>();

		for (int i = 0; i < stairSelection.length; i++) {
			stairList[stairSelection[i]].add(people.get(i));
			people.get(i).setArriveTime(stairSelection[i]);
		}
		int time = 0;

		while ((!stairList[0].isEmpty() || !stairList[1].isEmpty()) || (!curStair[0].isEmpty() || !curStair[1].isEmpty())) {
			++time;

			for (int i = 0; i < 2; i++) {
//				System.out.println("stairList" + stairList[i].size());
//				System.out.println("curStair" + curStair[i].size());
//				System.out.println();

				while (!curStair[i].isEmpty() && curStair[i].peek().outT == time) {
					curStair[i].poll();
				}

				while (curStair[i].size() < 3 && !stairList[i].isEmpty() && stairList[i].peek().avt < time) {
					stairList[i].peek().setOutTime(time, i);
					curStair[i].add(stairList[i].poll());
				}

			}
		}

		return time;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			curStair = new ArrayDeque[2];
			curStair[0] = new ArrayDeque<>();
			curStair[1] = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int cur = Integer.parseInt(st.nextToken());

					if (cur == 1)
						people.add(new Person(i, j));
					else if (cur > 0) {
						stairs.add(new int[] { cur, i, j });
					}
				}
			}

			stairSelection = new int[people.size()];

			make(0);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
