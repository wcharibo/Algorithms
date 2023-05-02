#include <iostream>

using namespace std;

int main(){
    int arr[9][9] ={0};
    for(int i=0;i<9;i++){
        cin>>arr[i][0]>>arr[i][1]>>arr[i][2]>>arr[i][3]>>arr[i][4]>>arr[i][5]>>arr[i][6]>>arr[i][7]>>arr[i][8];
    }
    int max=0, maxC, maxR;
    for(int i=0;i<9;i++){
        for (int j = 0; j < 9; j++)
        {
            if(arr[i][j]>100||arr[i][j]<0){
                return 0;
            }
        }
        
    }

    for(int i=0;i<9;i++){
        for (int j = 0; j < 9; j++)
        {
            if(arr[i][j]>=max){
                max = arr[i][j];
                maxC = i;
                maxR = j;
            }
        }
        
    }
    cout<<max<<endl;
    cout<<maxC+1<<' '<<maxR+1;
    return 0;
}