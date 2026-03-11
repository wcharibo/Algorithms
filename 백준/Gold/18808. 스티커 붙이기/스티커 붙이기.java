import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] paper = new int[N][M];

		Pair[][] stickers = new Pair[K][];
		Pair[] stickerSize = new Pair[K];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			stickers[i] = new Pair[R * C + 1];
			stickerSize[i] = new Pair(R, C);

			for (int j = 0, idx = 0; j < R; j++) {
				String[] strs = br.readLine().split(" ");
				for (int k = 0; k < C; k++) {
					if (strs[k].equals("1"))
						stickers[i][idx++] = new Pair(j, k);
				}
			}
		}
		
		int stickerCnt = -1;
		for (Pair[] sticker : stickers) {
			stickerCnt++;
			outer:
			for (int i = 0; i < 4; i++) {

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						int idx = -1;
						boolean flag = true;
						while (sticker[++idx] != null) {
							int nr = r + sticker[idx].r;
							int nc = c + sticker[idx].c;

							if(nr >= N || nc >= M) {
								flag = false;
								break;
							}
							if (paper[nr][nc] == 1) {
								flag = false;
								break;
							}
							
						}

						if (flag) {
							idx = -1;
							while (sticker[++idx] != null) {
								paper[r + sticker[idx].r][c + sticker[idx].c] = 1;
							}
							
							break outer;
						}
					}
				}
				
				rotate(sticker, stickerSize[stickerCnt]);
				int temp = stickerSize[stickerCnt].r;
				stickerSize[stickerCnt].r = stickerSize[stickerCnt].c;
				stickerSize[stickerCnt].c = temp;
			}
			
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	private static void rotate(Pair[] sticker, Pair size) {
	    int len = 0;
	    for (Pair p : sticker) if (p != null) len++; // 유효 개수

	    Pair[] temp = new Pair[len];
	    for (int i = 0; i < len; i++) {
	        temp[i] = new Pair(sticker[i].c, size.r - 1 - sticker[i].r);
	    }

	    // 최소값 보정
	    int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
	    for (Pair p : temp) {
	        minR = Math.min(minR, p.r);
	        minC = Math.min(minC, p.c);
	    }

	    for (int i = 0; i < len; i++) {
	        sticker[i].r = temp[i].r - minR;
	        sticker[i].c = temp[i].c - minC;
	    }
	}

}