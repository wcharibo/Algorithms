import java.util.*;

class Solution {
    static int[] sets;
    
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int c;
        
        Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public int compareTo(Edge o){
            return this.c - o.c;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int unionCnt = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        sets = new int[n];
        
        for(int i = 0; i < n; i++){
            sets[i] = i;
        }
        
        for(int[] i : costs){
            pq.add(new Edge(i[0], i[1], i[2]));
        }
        
        while(!pq.isEmpty() && unionCnt < n - 1 ){
            Edge cur = pq.poll();
            
            if(union(cur.a, cur.b)){
                answer+=cur.c;
                unionCnt++;
            }
        }
        
        return answer;
    }
    
    static public int find(int a){
        if(sets[a] == a) return sets[a];
        
        return sets[a] = find(sets[a]);
    }
    
    static public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb){
            return false;
        }
        
        sets[pb] = pa;
        return true;
    }
}