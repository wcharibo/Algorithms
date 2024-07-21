#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0, flag=0;
    
    sort(citations.begin(), citations.end());
    
    int h = min(citations[0], int(citations.size()));
    
    while(flag==0){
        int temp = 0;
        for(int i : citations) if(i>=h) temp++;
        if(temp>=h) h++;
        else{
            answer=--h;
            flag=1;
        }
    }
    
    return answer;
}