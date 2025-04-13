#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer = {arr[0], };
    
    for(int i : arr) if(i != answer.back()) answer.push_back(i);

    return answer;
}