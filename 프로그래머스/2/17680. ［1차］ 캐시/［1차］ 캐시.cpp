#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

int find_cache(vector<string> &c, string city){
    int result;
    if(c.size()!=0){
        vector<string>::iterator i = find(c.begin(), c.end(), city);
        if(i==c.end()){
            c.erase(c.begin());
            c.push_back(city);
            result = 5;
        }
        else{
            c.erase(i);
            c.push_back(city);
            result = 1;
        }
    }
    else{
        result=5;
    }
        
    
    return result;
}

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    vector<string> cache(cacheSize, " ");
    
    for(string i : cities){
        for(int j = 0; j < i.size(); j++) i[j]=toupper(i[j]);
        answer+=find_cache(cache, i);
    }
    
    return answer;
}