// 비효율적인 반복 풀이 404ms
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int result = Integer.MAX_VALUE;
		
		if(D % P == 0 || D % Q == 0) {
			System.out.println(D);
			return;
		}
		
		int temp = Math.min(P, Q);
		Q = Math.max(P, Q);
		P = temp;
		
		int compensation = Q/P;
		
		int prevP = D/P + 1;
		int prevQ = 0;
		int curP = D/P + 1;
		int curQ = 0;
		
		while(curP >= 0 && curQ >= 0) {
			int cur = curP * P + curQ * Q;
//			System.out.println("before " + cur + "  P: " + curP + ". Q: " + curQ);
			result = Math.min(result , curP * P + curQ * Q);
			if(cur == D) {
				break;
			}
			
			
			curQ++;
			curP-=compensation;
			
			while(curP * P + curQ * Q >= D) {
				curP--;
			}
			
			curP++;
			
			cur = curP * P + curQ * Q;
//			System.out.println("after "+ cur + "  P: " + curP + ". Q: " + curQ);
			
//			if((prevP * P + prevQ*Q) - D < cur - D) {
//				curP = prevP;
//				curQ = prevQ;
//				break;
//			}
			
			prevP = curP;
			prevQ = curQ;
			
//			System.out.println("after "+ cur + "  P: " + curP + ". Q: " + curQ);
			
		}
		
		
//		System.out.println("-----------");
		System.out.println(result);
		
		
	}
}