#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<pair<int, pair<int,int>>> result;
    unordered_map<string , pair<int, pair<int, int>>> hash_table;
    
    for(size_t i = 0; i < genres.size(); i++){
        if(hash_table.find(genres[i]) != hash_table.end()){
            hash_table[genres[i]].first += plays[i];
            if(plays[hash_table[genres[i]].second.first] < plays[i]){
                hash_table[genres[i]].second.second = hash_table[genres[i]].second.first;
                hash_table[genres[i]].second.first = i;
            }
            else if(plays[hash_table[genres[i]].second.second] < plays[i]){
                hash_table[genres[i]].second.second = i;
            }
            else if(hash_table[genres[i]].second.first == hash_table[genres[i]].second.second){
                hash_table[genres[i]].second.second = i;
            }
            
        }
        else{
            hash_table.insert({genres[i], {plays[i], {i, i}  }  });
        }
        
    }
    
    
    for(auto iter = hash_table.begin(); iter != hash_table.end(); iter++){
        result.push_back({iter->second.first,{iter->second.second.first, iter->second.second.second}});
    }
    
    sort(result.rbegin(), result.rend());
    
    for(pair<int, pair<int, int>> i : result){
        if(i.second.first == i.second.second) answer.push_back(i.second.first);
        else{
            answer.push_back(i.second.first);
            answer.push_back(i.second.second);
        }
        cout<<i.first<<"  "<<plays[i.second.first]<<"  "<<plays[i.second.second]<<endl;
    }
    
    return answer;
}