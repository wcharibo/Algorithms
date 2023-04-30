#include<iostream>

using namespace std;

int main(){
    int a,b;
    cin>>a>>b;
    if(a>0&&b>0){
        cout<<a*(b%10)<<endl;
        cout<<a*((b%100)/10)<<endl;
        cout<<a*(b/100)<<endl;
        cout<<a*b;
    }
}