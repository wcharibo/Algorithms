#include <string>
#include <vector>
#include <iostream>

using namespace std;

pair <int, int> re_convert(pair<int, int> cnt_pair, string str){
    int cnt = cnt_pair.first;
    int zero_cnt = cnt_pair.second;
    
    int temp_size = 0;
    string temp = "";
    
    for(char i : str) i == '1' ? temp_size++ : zero_cnt++;
    
    for(int i = 18 ; i>=0; i--){ //2^18==262,144
        int digit = (temp_size>>i)&1;
        if(digit !=0 || temp.size()!=0) temp+=to_string(digit);
    }

    if(temp=="1") {return {++cnt, zero_cnt};}
    else{
        return re_convert({++cnt, zero_cnt}, temp);
    }
}

vector<int> solution(string s) {
    vector<int> answer;
    int cnt = 0, zero_cnt = 0;
    
    pair<int, int> result = re_convert({cnt, zero_cnt}, s);
    
    answer.push_back(result.first);
    answer.push_back(result.second);
    return answer;
}