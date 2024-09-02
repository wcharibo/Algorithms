#include <string>
#include <queue>
#include <vector>

using namespace std;

int solution(int x, int y, int n) {
    int answer = -1;
    queue<pair<int, int>> bfs;
    if(x == y) return 0;
    bfs.push({x,0});
    vector<int> record(1000000, 0);
    
    while(bfs.size()!=0){
        int cur = bfs.front().first;
        int cnt = bfs.front().second;
        vector<int> temp = {cur*2, cur*3, cur+n};
        for(int i : temp){
            if(i == y ) return cnt+1;
            else if(i < y && record[i]==0){ bfs.push({i, cnt+1}); record[i]=1;}
        }
        bfs.pop();
    }
    
    return answer;
}