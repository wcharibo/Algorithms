#include <iostream>

using namespace std;

int main(){
    int num, result = 0, cnt=0;
    cin>>num;
    
    while(num!=cnt){
        result++;
        int co_result = result;
        
        while(co_result!=0){
            if(co_result%1000==666){
                cnt++;
                break;
            }
            else{
                co_result/=10;
            }
        }
    }
    
    cout<<result;
}