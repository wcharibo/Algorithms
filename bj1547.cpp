#include <iostream>

using namespace std;

int main(){
    int arr[3]= {1,0,0};
    
    int cnt=0;
    int numArr[102] ={0};

    cin>>cnt;
    for(int i=0;i<cnt*2;i+=2){
        cin>>numArr[i]>>numArr[i+1];
    }
    int j=0;

    while(numArr[j]!=0){
        swap(arr[numArr[j]-1],arr[numArr[j+1]-1]);
        j+=2;
    }

    for(int i=0;i<3;i++){
        if(arr[i]==1){
            cnt=i+1;
            break;
        }
        else cnt=-1;
    }
    cout<<cnt;
    return 0;
}