#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

bool cal(string &a, string &b){
    return a+b > b+a;
}

int solution(string numbers) {
    int max, answer = 0;
    string max_str = "";
    vector<string> nums;
    vector<int> repeat_cnt(10,0);
    for(int i = 0; i < numbers.size(); i++){
        string temp{numbers[i]};
        nums.push_back(temp);
        repeat_cnt[stoi(temp)]++;
    }
    sort(nums.begin(), nums.end(), cal);
    
    for(string i : nums) max_str.append(i);
    
    max = stoi(max_str);
    int cnt_max = sqrt(max)+1;
    
    vector<int> decimal(max+1, 1);
    decimal[0] = 0;
    decimal[1] = 0;
    
    for(int i = 2; i <= cnt_max; i++){
        if(decimal[i] == 0) continue;
        for(int j = i+1; j < decimal.size(); j++) if(decimal[j] == 1 && j%i==0) decimal[j]=0;
    }
    
    vector<string> str_decimal;
    for(int i = 0; i < decimal.size(); i++) if(decimal[i]==1) str_decimal.push_back(to_string(i));
    
    for(string temp : str_decimal){
        vector<int> repeat_temp(repeat_cnt);
        int flag = 0;
        for(int i = 0; i < temp.size(); i++){
            repeat_temp[temp[i] - '0']--;
        }
        for(int j : repeat_temp) if(j<0) flag=1;
        
        if(flag==0) answer++;
    }
    
    
    return answer;
}