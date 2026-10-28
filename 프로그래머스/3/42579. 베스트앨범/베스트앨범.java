import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        
        PriorityQueue<int[]>[] playsPerGenres = new PriorityQueue[100];
        int[] totalPlaysPerGenres = new int[100];
        HashMap<String, Integer> gMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            
            if(gMap.get(genres[i]) == null){
                gMap.put(genres[i], gMap.size());
                
                playsPerGenres[gMap.size() - 1] = new PriorityQueue<>((int[] a, int[] b)->{return a[1] == b[1] ? a[0] - b[0] : b[1] - a[1];});
                totalPlaysPerGenres[gMap.size() - 1] = 0;
            }
            
            int idx = gMap.get(genres[i]);
            
            playsPerGenres[idx].add(new int[] {i, plays[i]});
            totalPlaysPerGenres[idx] += plays[i];
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {return totalPlaysPerGenres[b] - totalPlaysPerGenres[a];});
        
        for(int i = 0; i < gMap.size(); i++) q.add(i);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            int cnt = 0;
            
            while(cnt < 2 && !playsPerGenres[cur].isEmpty()){
                ans.add(playsPerGenres[cur].poll()[0]);
                cnt++;
            }
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}