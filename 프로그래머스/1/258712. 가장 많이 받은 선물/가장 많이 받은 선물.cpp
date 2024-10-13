#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <iostream>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    const int fr_num = friends.size();
    
    vector<vector<int>> gift_table(fr_num, vector<int>(fr_num+1,0));
    vector<int> gift_result(fr_num, 0);
    
    unordered_map<string, int> name_to_num;
    for(int i = 0; i < fr_num; i++) name_to_num.insert({friends[i], i});
    
    for(string temp : gifts){
        string giver, taker;
        istringstream iss(temp);
        iss>>giver>>taker;
        gift_table[name_to_num[giver]][name_to_num[taker]]++;
        gift_table[name_to_num[taker]][name_to_num[giver]]--;
    }
    
    for(vector<int> &temp: gift_table){
        int sum = 0;
        for(int i : temp) sum+=i;
        temp[fr_num] = sum;
    }
    
    for(int i = 0; i < fr_num; i++){
        int next_month = 0;
        for(int j = 0; j < fr_num; j++){
            if(i == j) continue;
            if(gift_table[i][j] > 0) next_month++;
            else if(gift_table[i][j] == 0 && gift_table[i][fr_num] > gift_table[j][fr_num]) next_month++;
        }
        gift_result[i] = next_month;
    }
    
    for(int i : gift_result) if( i > answer) answer=i;
    
    return answer;
}