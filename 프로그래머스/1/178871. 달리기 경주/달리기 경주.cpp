#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    unordered_map<string, int> rank;
    
    for(int i=0; i<size(players); i++){
        rank.insert(make_pair(players[i], i));
    }
    
    for(int i=0; i<size(callings); i++){ 
        int a = rank.find(callings[i])->second;
        int b = a-1;
        
        string tmp = players[b];
        rank[callings[i]]=b;
        rank[tmp]=a;
        
        players[b]=callings[i];
        players[a]=tmp;
    }
    
    return players;
}