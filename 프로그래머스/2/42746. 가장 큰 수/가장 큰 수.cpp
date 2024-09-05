#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cal(string a, string b){
    string temp1 = a+b;
    string temp2 = b+a;
    
    return temp1>temp2;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> str_nums;
    for(int i : numbers) str_nums.push_back(to_string(i));
    
    sort(str_nums.begin(), str_nums.end(), cal);
    
    for(string i : str_nums) answer.append(i);
    
    if(answer[0] == '0') answer="0";
    
    return answer;
}