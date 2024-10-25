#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> clo_ctg;
    
    for(vector<string> a : clothes) if(clo_ctg.insert({a[1],1}).second==false) clo_ctg[a[1]]++;
    
    for(auto i = clo_ctg.begin(); i!=clo_ctg.end(); i++) answer*=(++(i->second));//2벌인 경우 안입기, 1번 입기, 2번 입기 로 3가지 경우로 다뤄주기 위해 1을 더해서 곱해줌
    answer--;//아무것도 입지 않은 경우
    return answer;
}