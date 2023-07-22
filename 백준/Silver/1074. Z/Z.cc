#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void digit(int a, vector<int> &digit);

int main(){
    int a, b, c, cnt=0;
    cin>>a>>b>>c;
    vector<int> x_digit, y_digit;
    int x=b, y=c;
    digit(x, x_digit);
    digit(y, y_digit);
    
    if(x_digit.size()>y_digit.size()){
        int d = x_digit.size()-y_digit.size();
        for(int i=0; i< d; i++) y_digit.push_back(0);
    }
    else if(x_digit.size()<y_digit.size()){
        int d = y_digit.size()-x_digit.size();
        for(int i=0; i< d; i++) x_digit.push_back(0);
    }
    
    for(int i=0; i< x_digit.size(); i++){
        if(x_digit[i] < y_digit[i]){
            cnt+=pow(4,i);
        }
        else if(x_digit[i] > y_digit[i]){
            cnt+=2*pow(4,i);
        }
        else if(x_digit[i]==y_digit[i]&&x_digit[i]==1){
            cnt+=3*pow(4,i);
        }
    }
    
    cout<<cnt;
}

void digit(int a, vector <int> &digit){
    if(a<=1) digit.push_back(a);
    else{
        while(a>1){
            digit.push_back(a%2);
            a/=2;
            if(a==1){
                digit.push_back(a);
            }
        }
    }
}