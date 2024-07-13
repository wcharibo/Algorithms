#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<int> arr) {
    int answer = 1;
    
    vector<int> prime_num;
    for(int i = 2; i<101; i++){
        int flag = 0;
        for(int j = 2; j<=i/2; j++){
            if(j!=1 && i%j==0){
                flag = 1;
                break;
            }
        }
        if(flag==0) prime_num.push_back(i);
    }
    
    vector<int> cnt(prime_num.size(), 0);
    
    for(int num : arr){
        vector<int> temp(prime_num.size(), 0);
        for(int i = 0; i<prime_num.size(); i++){
            if(num%prime_num[i]==0){
                num/=prime_num[i];
                temp[i]++;
                i--;//제곱인지 확인하기 위해
            }
        }
        for(int i = 0; i<prime_num.size(); i++) cnt[i]=max(cnt[i], temp[i]);
    }
    
    for(int i =0; i<prime_num.size(); i++){
        if(cnt[i]!=0) answer*=pow(prime_num[i],cnt[i]);
    }
    
    return answer;
}