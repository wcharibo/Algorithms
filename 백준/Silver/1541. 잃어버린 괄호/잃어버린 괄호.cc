#include <iostream>
#include <string>

using namespace std;
int main(){
    string n;
    cin>>n;
    int flag=0, result=0;
    string num;

    for(int i=0;i<=n.length();i++){
        if (n[i]=='-'||n[i]=='+'||i==n.length())
        {
            if(flag==1){
                result-=stoi(num);
                num="";
            }
            else {
                result+=stoi(num);
                num="";
            }
        }
        else{
            num+=n[i];
        }
        
        if(n[i]=='-'){
            flag=1;
        }
    }
    
    cout<<result;
}