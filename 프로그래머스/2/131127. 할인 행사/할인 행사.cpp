#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    unordered_map<string, int> search_map;
    
    for(int i = 0; i < want.size(); i++) search_map.insert({want[i], i});
    
    for(int i = 0; i <= (discount.size()-10); i++){
        vector<int> possible(want.size(), 0);
        for(int j = i; j < i+10; j++){
            auto temp = search_map.find(discount[j]);
            if(temp!=search_map.end()) possible[temp->second]++;
        }
        if(possible==number) answer++;
    }
    
    return answer;
}