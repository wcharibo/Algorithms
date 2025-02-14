#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool order(pair<int, int> a, pair<int, int> b){
    if(a.second - a.first == b.second - b.first) return a.first < b.first;
    return a.second-a.first < b.second-b.first;
}

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    vector<pair<int, int>> pos_ans;
    int start = 0, end = 0, temp = sequence[0];
    
    while(start < sequence.size() && end < sequence.size()){
        if(sequence[start] > k) break;
        else if(temp == k) {pos_ans.push_back({start, end});temp -= sequence[start++];}
        else if(temp < k) temp += sequence[++end];
        else if(temp > k) temp -= sequence[start++];
    }
    
    sort(pos_ans.begin(), pos_ans.end(), order);
    pair<int,int> shortest = *(pos_ans.begin());
    answer = {shortest.first, shortest.second};
    
    return answer;
}