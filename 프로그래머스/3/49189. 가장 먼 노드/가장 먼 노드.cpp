#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0, temp = 0;
    
    vector<vector<int>> g(n);
    vector<int> visited(n, 0);
    queue<int> q;
    
    for(vector<int> i : edge){
        int x = i[0]-1, y = i[1]-1;
        g[x].push_back(y);
        g[y].push_back(x);
        
        if(x==0 || y==0){
            visited[0] = 1;
            if(x==0){
                q.push(y);
                visited[y] = 2;
            }
            else{
                q.push(x);
                visited[x] = 2;
            }
        }
    }
    
    while(!q.empty()){
        int cur_node = q.front();
        
        for(int i : g[cur_node]){
            if(visited[i] == 0){
                q.push(i);
                visited[i] = visited[cur_node] + 1;
            }
        }
        
        q.pop();
    }
    
    for(int i : visited){
        if(i > temp){
            temp = i;
            answer = 1;
        }
        else if( i == temp) answer++;
    }
    
    return answer;
}