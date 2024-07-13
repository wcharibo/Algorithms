#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    
    int wrong ,flag = 1;
    
    for(int i =1; i<words.size(); i++){
        if(flag!=0 && (*(words[i-1].end()-1) != words[i][0] || find(words.begin(), words.begin()+i, words[i]) != words.begin()+i)){
            flag=0;
            wrong = i+1;//번째로 기록하기 위함
        }
    }
    
    if(flag==0){
        if(wrong%n==0){
            answer.push_back(n);
            answer.push_back(wrong/n);
        }
        else{
            answer.push_back(wrong%n);
            answer.push_back(wrong/n+1);
        }
    }
    else{
        answer.push_back(0);
        answer.push_back(0);
    }
    
    
    return answer;
}