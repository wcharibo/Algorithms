#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer, temp;
    vector<pair<int,int>> conclusion;
    string str_nums, str_seg;
    int max=0;
    
    for(int i = 0; i< s.size(); i++){
        if(s[i]!='{' && s[i]!='}') str_nums+=s[i];
    }
    
    istringstream iss(str_nums);
    while(getline(iss, str_seg, ',')){
        temp.push_back(stoi(str_seg));
        if(temp.back()>max) max = temp.back();
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