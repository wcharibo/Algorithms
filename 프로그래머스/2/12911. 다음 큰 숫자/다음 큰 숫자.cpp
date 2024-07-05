#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <cstdlib>
#include <algorithm>

using namespace std;

int convert(int a){
    string arr="";
    for(int i = 20; i>=0; i--){
        int temp = (a>>i)&1;
        if(temp!=0 || arr.size()!=0) arr+=to_string(temp);
    }
    return count(arr.begin(), arr.end(), '1');
}

int solution(int n) {
    int answer = n+1;
    string arr="";
    
    int temp = convert(n);
    
    while(temp!=convert(answer)){
        answer++;
    }
    // int flag=-1;
    // for(int i = arr.size()-1; i>=0; i--){
    //     if(arr[i]=='1' &&arr[i-1]=='0'){
    //         flag=i;
    //         break;
    //     }
    // }
    // if(flag!=-1){
    //     arr[flag-1]='1';
    //     arr[flag]='0';
    // }
    // else{
    //     arr[1]='0';
    //     arr+=to_string(1);
    // }
    // cout<<arr;
    // for(int i = 0; i<arr.size(); i++){
    //     answer+=pow((int(arr[i])-'0')*2, arr.size()-i-1);
    // }
    return answer;
}