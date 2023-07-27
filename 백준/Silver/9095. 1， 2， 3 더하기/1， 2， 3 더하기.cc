#include <iostream>
#include <vector>


using namespace std;

vector <int> arr(11,0);

int cal(int a);

int main() {
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int testNum;
    arr[1]=1;
    arr[2]=2;
    arr[3]=4;
    arr[4]=7;
    
    cin>>testNum;
    
    for(int i=0; i<testNum; i++){
        int temp;
        cin>>temp;
        int result = cal(temp);
        cout<< result <<'\n';
    }
    
}

int cal(int a){
    if(arr[a]!=0){
        return arr[a];
    }
    else{
        arr[a]=cal(a-1) + cal(a-2) + cal(a-3);
        return arr[a];
    }
}
