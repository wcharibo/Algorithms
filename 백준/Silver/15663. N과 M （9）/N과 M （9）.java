import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static ArrayList<Integer> numbs = new ArrayList<>();
	static Set<List<Integer>> result = new TreeSet<>((a, b) -> {
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) == b.get(i)) continue;
			else return a.get(i) - b.get(i);
		}
		return 0;
	});
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] visited;
	
	static void fill(Integer cur) {
		for(int i = 0; i < numbs.size(); i++) {
			if(cur == M) {
				if(!visited[i]) {
					arr.add(numbs.get(i));
					result.add(new ArrayList<>(arr));
					arr.remove(arr.size()-1);
				}
			}
			else if(!visited[i]) {
				arr.add(numbs.get(i));
				visited[i] = true;
				fill(cur+1);
				arr.remove(arr.size()-1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			numbs.add( Integer.parseInt(st.nextToken()));
		}
		numbs.sort((a,b)-> a-b);
		
		fill(1);
		
		for(List<Integer> r : result) {
			for(int i : r) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
}