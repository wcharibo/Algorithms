#include <iostream>
#include <queue>
#include <cstdlib>

using namespace std;

int result;
vector <int> visited;

void move(pair<int,int> x, int y, queue<pair<int,int> > &q);

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int start, end, moveCnt=0;
    visited.resize(100001, 0);
    queue<pair<int,int> > order;
    
    cin>>start>>end;
    
    order.push(make_pair(start,0));
    visited[start]=1;
    move(make_pair(start, moveCnt), end, order);
    cout<<result;
}

void move(pair<int,int> x, int y, queue<pair<int,int> > &q){
    if(x.first==y) result =  x.second;
    else{
        x.second++;
        if(visited[x.first-1]==0 && x.first -1 >=0 && x.first-1 <=100000){
            if(x.first-1==y) {result = x.second; return;}
            visited[x.first-1]=1;
            q.push(make_pair(x.first-1,x.second));
        }
        if(visited[x.first+1]==0 && x.first+1<=100000 && x.first +1 >=0){
            if(x.first+1==y) {result = x.second; return;}
            visited[x.first+1]=1;
            q.push(make_pair(x.first+1,x.second));
        }
        if(visited[x.first*2]==0 && x.first*2<=100000 && x.first*2 >=0){
            if(x.first*2==y) {result = x.second; return;}
            visited[x.first*2]=1;
            q.push(make_pair(2*x.first,x.second));
        }
        q.pop();
        move(q.front(), y, q);
    }
}