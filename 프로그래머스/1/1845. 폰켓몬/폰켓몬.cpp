#include <vector>
#include <map>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    map<int, int> pockets;
    for(int i : nums) if(pockets.insert({i, 1}).second == true) continue; else pockets[i]++;
    
    return answer = min(pockets.size(), nums.size()/2);
}