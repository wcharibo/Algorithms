#include <iostream>

using namespace std;

int main(){
    int n,k,cnt=0;
    cin>>n>>k;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    if(n>=1&&n<=10&&k>=1&&k<=100000000){
        for(int i=n;i>=0;--i){
            if(i!=0&&a[i]%a[i-1]!=0) return 0;
            if(k/a[i]>0){
                cnt+=k/a[i];
                k=k%a[i];
            }
        }
        cout<<cnt;
    }
    return 0;
}