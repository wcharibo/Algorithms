#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int n, m, temp;
    cin>>n>>m;
    vector <int> arr(n+1,0);
    
    for(int i=1; i<=n; i++){
        cin>>temp;
        arr[i] = temp + arr[i-1];
    }
    
    for(int i=0; i<m; i++){
        int x, y;
        cin>>x>>y;
        cout<<arr[y]-arr[x-1]<<'\n';
    }
}