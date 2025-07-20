import java.util.*;
import java.io.*;

public class Main {
	static class Member{
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numPeople = Integer.parseInt(br.readLine());
		ArrayList <Member> members = new ArrayList<>();
		
		for(int i = 0; i < numPeople; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members.add(new Member(age, name));
		}
		
		members.sort(Comparator.comparingInt(member -> member.age));
		
		StringBuilder sb = new StringBuilder();
		
		for(Member member : members) sb.append(member.age).append(" ").append(member.name).append("\n");
		
		System.out.println(sb);
	}
}
