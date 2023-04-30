#include <iostream>

using namespace std;

int main(){
    int a,b;
    cin>>a>>b;
    if(a>=1&&a<=10000&&b>=1&&b<=10000){
        cout<<a+b<<endl;
        cout<<a-b<<endl;
        cout<<a*b<<endl;
        cout<<a/b<<endl;
        cout<<a%b<<endl;
    }

    return 0;
}