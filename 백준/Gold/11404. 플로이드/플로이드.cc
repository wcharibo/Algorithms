#include <iostream>
#include <limits>
#include <vector>

using namespace std;

const int INF = 10000000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int city, bus;
    cin>>city;
    cin>>bus;
    
    vector<vector<int>> dist(city, vector<int> (city, INF));
    for(int i = 0; i < city; i++){
        dist[i][i] = 0;
    }
    
    while(bus--){
        int start, end, weight;
        cin>>start>>end>>weight;
        dist[start-1][end-1] = min(dist[start-1][end-1], weight);
    }
    
    for(int i = 0; i < city; i++){
        for(int j = 0; j < city; j++){
            for(int l = 0; l < city; l++){
                dist[j][l] = min(dist[j][l], dist[j][i] + dist[i][l]);
            }
        }
    }
    
    for(vector<int> i : dist){
        for(int j: i) j == INF ? cout<<0<<" " : cout<<j<<" ";
        cout<<endl;
    }
    
}