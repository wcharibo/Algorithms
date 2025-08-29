import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] paperCnt;
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

	static void get(int row, int col, int size) {
		if (size == 1)
			paperCnt[map[row][col]]++;
		else {
			int flag = map[row][col];
			for (int i = row; i < row+size; i++) {
				for (int j = col; j < col+size; j++) {
					if (flag != map[i][j]) {
						for (int k = 0; k < 4; k++) {
							get(row + dir[k][0] * size / 2, col + dir[k][1] * size / 2, size / 2);
						}
						return;
					}
				}
			}
			paperCnt[map[row][col]]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		paperCnt = new int[2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		get(0, 0, N);

		System.out.println(paperCnt[0]);
		System.out.println(paperCnt[1]);
	}
}
