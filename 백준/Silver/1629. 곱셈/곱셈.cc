#include <iostream>
 using namespace std;
 int a,b,c;
 long long z(int a, int b, int c);
 int main(){
    cin>>a>>b>>c;
    long long p;
    p=z(a,b,c);
    cout<<p;
 }

 long long z(int x, int y, int k){
    if(y==1) return x%k;
    else if(y%2==0){
        return (z(x,y/2,k)%k*z(x,y/2,k)%k)%k;
    }
    else{
        return (z(x,y/2,k)%k*z(x,y/2+1,k)%k)%k;
    }
 }
