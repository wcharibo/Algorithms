#include <string>
#include <vector>

using namespace std;

int dfs(vector<int> nums, int tar, int cnt, int sum){
    int target_reached = 0;
    if(cnt != nums.size()-1){
        target_reached+=dfs(nums, tar, cnt+1, sum+nums[cnt]);
        target_reached+=dfs(nums, tar, cnt+1, sum-nums[cnt]);
    }
    else{
        if(tar==sum+nums[cnt]) target_reached++;
        else if(tar==sum-nums[cnt]) target_reached++;
    }
    
    return target_reached;
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    answer = dfs(numbers, target, 0, 0);
    return answer;
}