#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0, temp = 0;
    
    vector<vector<int>> g(n, vector<int> (n, -1));
    vector<int> visited(n, 0);
    queue<pair<int, int>> q;
    
    for(vector<int> i : edge){
        int x = i[0]-1, y = i[1]-1;
        g[x][y] = 0;
        g[y][x] = 0;
        
        if(x==0 || y==0){
            visited[0] = 1;
            x == 0 ? q.push({y,2}) : q.push({x, 2});
        }
    }
    
    while(!q.empty()){
        int cur_node = q.front().first;
        
        if(visited[cur_node] == -1) visited[cur_node] = q.front().second;
        else if(visited[cur_node] != 0) visited[cur_node] = min(visited[cur_node], q.front().second);
        else visited[cur_node] = q.front().second;
        
        for(int i = 0; i < n; i++){
            if(g[cur_node][i] == 0 && visited[i] == 0){
                q.push({i, q.front().second + 1});
                visited[i] = -1;
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