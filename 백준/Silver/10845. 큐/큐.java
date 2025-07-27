import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Integer> joseph = new LinkedList<>();
		int back = 0;
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case("push"):
				int temp = Integer.parseInt(st.nextToken());
				joseph.add(temp);
				back = temp;
				break;
			case("front"):
				if(joseph.isEmpty()) result.append(-1);
				else result.append(joseph.peek());
				result.append("\n");
				break;
			case("back"):
				if(joseph.isEmpty()) result.append(-1);
				else result.append(back);
				result.append("\n");
				break;
			case("size"):
				result.append(joseph.size()).append("\n");
				break;
			case("empty"):
				if(joseph.isEmpty()) result.append(1);
				else result.append(0);
				result.append("\n");
				break;
			case("pop"):
				if(joseph.isEmpty()) result.append(-1);
				else result.append(joseph.poll());
				result.append("\n");
				break;		
			}			
		}
		
		System.out.println(result);
	}
}
