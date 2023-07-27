#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector <vector <int> > input, dist;
queue <pair<int, pair<int, int> > > q;
int n,m;

void cal();

int main() {
    pair <int, int> start;
    cin>>n>>m;
    input.resize(n, vector<int>(m, 0));
    dist.resize(n, vector<int>(m, 10000000));
    for(int i = 0; i<n; i++){
        for(int j=0; j< m; j++){
            cin>>input[i][j];
            if(input[i][j]==2) start=make_pair(i,j);
            if(input[i][j]==0) dist[i][j]=0;
        }
    }
    
    q.push(make_pair(0, start));
    
    cal();
    
    for(int i = 0; i<n; i++){
        for(int j=0; j< m; j++){
            cout<<dist[i][j]<<' ';
        }
        cout<<'\n';
    }
}

void cal(){
    pair<int, pair<int, int> > temp;
    temp = q.front();
    pair<int, int> x= temp.second;
    int y = temp.first +1;
    dist[x.first][x.second]=y-1;
    
    if(x.first-1>=0 && input[x.first-1][x.second]==1 && dist[x.first-1][x.second] > y) {
        q.push(make_pair(y, make_pair(x.first-1, x.second)));
        dist[x.first-1][x.second]=y;
    }
    if(x.second-1>=0 && input[x.first][x.second-1]==1 && dist[x.first][x.second-1] > y) {
        q.push(make_pair(y, make_pair(x.first, x.second-1)));
        dist[x.first][x.second-1]=y;
    }
    if(x.first+1< n && input[x.first+1][x.second]==1 && dist[x.first+1][x.second] > y) {
        q.push(make_pair(y, make_pair(x.first+1, x.second)));
        dist[x.first+1][x.second]=y;
    }
    if(x.second+1< m && input[x.first][x.second+1]==1 && dist[x.first][x.second+1] > y){
        q.push(make_pair(y, make_pair(x.first, x.second+1)));
        dist[x.first][x.second+1]=y;
    }

    q.pop();
    
    if(q.empty()){
        for(int i = 0; i<n; i++){
            for(int j=0; j< m; j++){
                if(dist[i][j]==10000000) dist[i][j]=-1;
            }
        }
        return;
    }
    
    cal();
    
}
