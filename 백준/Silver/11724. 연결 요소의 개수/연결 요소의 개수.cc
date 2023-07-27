#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int x, vector <vector< int> > &g, vector <int> &v);

int main() {
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int edgeNum, vertexNum;
    cin>>edgeNum>>vertexNum;
    vector <vector <int> > graph(edgeNum);
    vector <int> visited(edgeNum, 0);
    for(int i = 0; i<vertexNum; i++){
        int temp1, temp2;
        cin>>temp1>>temp2;
        graph[temp1-1].push_back(temp2-1);
        graph[temp2-1].push_back(temp1-1);
    }
    
    int cnt=0;
    
    for(int i=0; i<edgeNum; i++){
        if(visited[i]==0){
            dfs(i, graph, visited);
            cnt++;
        }
    }
    
    cout<<cnt;
}

void dfs(int x, vector <vector< int> > &g, vector <int> &v){
    v[x]=1;
    for(int i = 0; i< g[x].size(); i++){
        if(v[g[x][i]]==0) dfs(g[x][i], g, v);
    }
}
