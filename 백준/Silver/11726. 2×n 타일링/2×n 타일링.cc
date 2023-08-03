#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int n;
    vector <int> arr;
    cin>>n;
    arr.resize(1001,0);
    arr[1]=1;
    arr[2]=2;
    for(int i=3; i<= n; i++){
        arr[i]= (arr[i-1]+arr[i-2])%10007;
    }
    
    cout<<arr[n];
}