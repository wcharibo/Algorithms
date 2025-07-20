import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> cards = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) cards.add(i);
		
		int cnt = 0;
		while(cards.size() - cnt > 1) {
			cnt++;
			cards.add(cards.get(cnt));
			cnt++;
		}
		
			
		System.out.println(cards.get(cnt));
	}
}
