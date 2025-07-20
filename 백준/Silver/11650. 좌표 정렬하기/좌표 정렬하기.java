import java.util.*;
import java.io.*;

public class Main {
	
	static class LocComparator implements Comparator<Location>{
		public int compare(Location loc1, Location loc2) {
			if(loc1.x == loc2.x) return loc1.y - loc2.y;
			return loc1.x - loc2.x;
		}
	}
	
	static class Location{
		int x;
		int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numLoc = Integer.parseInt(br.readLine());
		ArrayList <Location> locs = new ArrayList<>();
		
		for(int i = 0; i < numLoc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			locs.add(new Location(x, y));
		}
		
		locs.sort(new LocComparator());
		
		StringBuilder sb = new StringBuilder();
		
		for(Location loc : locs) sb.append(loc.x).append(" ").append(loc.y).append("\n");
			
		System.out.println(sb);
	}
}
