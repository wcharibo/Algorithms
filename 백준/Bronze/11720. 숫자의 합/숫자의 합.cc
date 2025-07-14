#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int num_num, answer = 0;
    string num;
    
    cin>>num_num;
    cin>>num;
    
    
    
    for(auto i : num) answer += int(i)-48;
    
    cout<<answer;
}