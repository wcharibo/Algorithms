#include<vector>
#include<queue>

using namespace std;

// queue<pair<pair<int, int>, int> > nexts;

// int bfs(vector<vector<int>> m, int start_r, int start_c, int cost){
//     int temp = 10000000;
//     m[start_r][start_c] = 0;
    
//     if(start_r==m.size()-1 && start_c==m[0].size()-1) return ++cost;
    
//     if(start_r - 1 >= 0 && m[start_r - 1][start_c] == 1){
//         nexts.push({{start_r-1, start_c}, cost+1});
//         m[start_r-1][start_c] = 0;
//     }
//     if(start_r + 1 <= m.size() - 1 && m[start_r + 1][start_c] == 1){
//         nexts.push({{start_r+1, start_c}, cost+1});
//         m[start_r+1][start_c] = 0;
//     }
//     if(start_c - 1 >= 0 && m[start_r][start_c - 1] == 1){
//         nexts.push({{start_r, start_c-1}, cost+1});
//         m[start_r][start_c-1] = 0;
//     }
//     if(start_c + 1 <= m[0].size() - 1 && m[start_r][start_c + 1] == 1){
//         nexts.push({{start_r, start_c+1}, cost+1});
//         m[start_r][start_c+1] = 0;
//     }
    
//     if(nexts.empty()) return -1;
//     else{
//         auto a = nexts.front();
//         nexts.pop();
//         temp = bfs(m, a.first.first, a.first.second, a.second);
//         return temp;
//     }
    
//     return temp;
// }

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    queue<pair<pair<int,int>, int>> q;
    
    q.push({{0, 0}, answer});
    maps[0][0] = 0;
    
    while(!q.empty()){
        auto a = q.front();
        int start_r = a.first.first, start_c = a.first.second, cost = a.second;
        q.pop();
        
        if(start_r==maps.size()-1 && start_c==maps[0].size()-1) return ++cost;
    
        if(start_r - 1 >= 0 && maps[start_r - 1][start_c] == 1){
            q.push({{start_r-1, start_c}, cost+1});
            maps[start_r-1][start_c] = 0;
        }
        if(start_r + 1 <= maps.size() - 1 && maps[start_r + 1][start_c] == 1){
            q.push({{start_r+1, start_c}, cost+1});
            maps[start_r+1][start_c] = 0;
        }
        if(start_c - 1 >= 0 && maps[start_r][start_c - 1] == 1){
            q.push({{start_r, start_c-1}, cost+1});
            maps[start_r][start_c-1] = 0;
        }
        if(start_c + 1 <= maps[0].size() - 1 && maps[start_r][start_c + 1] == 1){
            q.push({{start_r, start_c+1}, cost+1});
            maps[start_r][start_c+1] = 0;
        }
        
    }
    
    return -1;
}