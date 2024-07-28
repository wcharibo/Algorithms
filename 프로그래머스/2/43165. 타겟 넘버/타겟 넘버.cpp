#include <string>
#include <vector>

using namespace std;

int dfs(vector<int> nums, int tar, int cnt, int sum){
    int target_reached = 0;
    if(cnt != nums.size()-1){
        int temp1 = sum+nums[cnt];
        int temp2 = sum-nums[cnt];
        cnt++;
        target_reached+=dfs(nums, tar, cnt, temp1);
        target_reached+=dfs(nums, tar, cnt, temp2);
    }
    else{
        int temp = sum;
        if(tar==temp+nums[cnt]) target_reached++;
        else if(tar==temp-nums[cnt]) target_reached++;
    }
    
    return target_reached;
}

int solution(vector<int> numbers, int target) {
    int answer = 0;
    answer = dfs(numbers, target, 0, 0);
    return answer;
}