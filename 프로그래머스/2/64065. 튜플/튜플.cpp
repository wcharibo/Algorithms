#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer, temp;
    vector<pair<int,int>> conclusion;
    string str_num, str_seg;
    int max=0;
    
    for(char i : s){
        if(i-'0'>=0 && i-'0'<=9) str_num+=i;
        else{
            if(str_num.size()){
                temp.push_back(stoi(str_num));
                if(temp.back()>max) max = temp.back();
            }
            str_num.clear();
        }
    }
    
    conclusion.resize(max+1, {0,0});
    
    for(int i : temp){
        conclusion[i].first++;
        conclusion[i].second = i;
    }
    
    sort(conclusion.rbegin(), conclusion.rend());
    
    for(pair<int,int> i : conclusion) if(i.first!=0){answer.push_back(i.second);}
    return answer;
}