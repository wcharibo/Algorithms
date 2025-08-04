import java.util.*;
import java.awt.Point;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int max = Integer.MIN_VALUE;
    	ArrayList<Point> viruses = new ArrayList<>();
    	int[][] lab = new int[N][M];
    	boolean[][] firVst = new boolean[N][M];
    	boolean[][] secVst = new boolean[N][M];
    	int[] dir_x = {-1, 1, 0, 0}, dir_y = {0, 0, -1, 1};
    	
    	
    	for(int i = 0 ; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			lab[i][j] = Integer.parseInt(st.nextToken());
    			if(lab[i][j] != 0) {
    				firVst[i][j] = true;
    				if(lab[i][j] == 2) {
    					viruses.add(new Point(i,j));
    				}
    			}
    		}
    	}
    	
    	for(int firX = 0; firX < N; firX++) {
    		for(int firY = 0; firY < M; firY++) {
    			if(lab[firX][firY] == 0) {
    				firVst[firX][firY] = true;
    				
    				for(int k = 0; k < N; k++) {
    					secVst[k] = Arrays.copyOf(firVst[k], M);
    				}
    				
    				for(int secX = 0; secX < N; secX++) {
    					for(int secY = 0; secY < M; secY++) {
    						if(!firVst[secX][secY]) {
    							secVst[secX][secY] = true;
    							
    							for(int thrX = 0; thrX < N; thrX++) {
    								for(int thrY = 0; thrY < M; thrY++) {
    									if(!secVst[thrX][thrY]) {
    										int cnt = 0;
    										int[][] tempLab = new int[N][M];
    										Queue<Point> q = new LinkedList<>();
    										for(int i = 0; i < N; i++) {
    											tempLab[i] = Arrays.copyOf(lab[i], M);
    										}
    										
    										tempLab[firX][firY] = 1;
    										tempLab[secX][secY] = 1;
    										tempLab[thrX][thrY] = 1;
    										
    										for(Point virus: viruses) {
    											q.add(virus);
    										}
    										
    								
    										while(!q.isEmpty()) {
    											Point cur = q.poll();
    											
    											for(int i = 0; i < 4; i++) {
    												int nextX = cur.x + dir_x[i], nextY = cur.y + dir_y[i];
    												if(0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
    													if(tempLab[nextX][nextY] == 0) {
    														tempLab[nextX][nextY] = 2;
    														q.add(new Point(nextX, nextY));
    													}
    												}
    											}
    										}
    										
    										for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) if(tempLab[i][j] == 0) cnt++;
  
    										
    										max = Math.max(cnt, max);
    									}
    								}
    							}
    						}	
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(max);
    	
     
    	
    }
}