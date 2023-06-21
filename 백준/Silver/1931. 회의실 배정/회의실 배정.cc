#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int conferNum;
    vector <vector<int> > conferArr;
    cin>>conferNum;
    conferArr.resize(conferNum);
    for(int i = 0; i<conferNum; i++){
        conferArr[i].resize(2);
    }
    for(int i = 0; i< conferNum;i++){
        for(int j = 0; j<2;j++){
            cin>>conferArr[i][j];
        }
    }
    
    sort(conferArr.begin(), conferArr.end(), [](vector <int> &arr1, vector <int> &arr2) -> bool{if(arr1[1]==arr2[1]){return arr1[0]<arr2[0];} else return arr1[1]<arr2[1]; } );
    
    int anchor = conferArr[0][1];
    
    for(int i=1; i<conferNum; i++){
        if(conferArr[i][0]<anchor){
            conferArr[i][0]=-1,conferArr[i][1]=-1;
        }
        else{
            anchor = conferArr[i][1];
        }
    }
    int cnt=0;
    for(int i = 0; i< conferNum;i++){
        if(conferArr[i][1]>=0) cnt++;
    }
    cout<<cnt;
}