#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    int min = 21;
    unordered_map<string, int> phone_head;
    
    for(string i : phone_book) if(i.size() < min) min = i.size();
    
    for(int i = 0; i < phone_book.size(); i++){
        for(int j = min; j <= phone_book[i].size(); j++){
            if(phone_head.insert({phone_book[i].substr(0,j), i}).second == false){
                int temp = phone_head.find(phone_book[i].substr(0,j))->second;
                int min_size = phone_book[i].size()>phone_book[temp].size() ? phone_book[temp].size() : phone_book[i].size();
                if(min_size == j) return false;
            }
        }
    }
    
    return answer;
}