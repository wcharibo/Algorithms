#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector <int> graph[101], visited(101, 0);

void dfs(int x);

int main() {
    int comNum, vertexNum;
    cin>>comNum>>vertexNum;
    for(int i = 0; i<vertexNum; i++){
        int temp1, temp2;
        cin>>temp1>>temp2;
        graph[temp1].push_back(temp2);
        graph[temp2].push_back(temp1);
    }
    
    dfs(1);
    
    cout<<count(visited.begin(), visited.end(), 1)-1;
}

void dfs(int x){
    visited[x]=1;
    for(int i = 0; i< graph[x].size(); i++){
        if(visited[graph[x][i]]==0) dfs(graph[x][i]);
    }
}
