#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// vector<queue<int>> div(queue<int> a, int anc){
    
//     queue<int> temp1;
//     queue<int> temp2;
    
//     do{
        
//         temp1.push(a.front());
//         a.pop();
//         anc--;
        
//     }while(anc > 0);
        
//     while(!a.empty()){
//         temp2.push(a.front());
//         a.pop();
//     }
    
//     return {temp1, temp2};
// }

// queue<int> merge(queue<int> b, queue<int> c){
    
//     queue<int> temp;
    
//     while(!b.empty() && !c.empty()){
        
//         if(b.front() <= c.front()){
//             temp.push(b.front());
//             b.pop();
//         }
//         else{
//             temp.push(c.front());
//             c.pop();
//         }
//     }
    
//     while(!b.empty()){
//         temp.push(b.front());
//         b.pop();
//     }
    
//     while(!c.empty()){
//         temp.push(c.front());
//         c.pop();
//     }
    
    
//     return temp;
// }

// queue<int> quick(queue<int> a){
    
//     if(a.size() == 1) return a;
    
//     queue<int> temp;
    
//     int anchor = a.size()/2 - 1;
    
//     vector<queue<int>> div_a = div(a, anchor);
    
//     queue<int> sorted_a1 = quick(div_a[0]);
//     queue<int> sorted_a2 = quick(div_a[1]);
    
//     temp = merge(sorted_a1, sorted_a2);
    
//     return temp;
// }

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
//     queue<int> unsorted_answer, result;
    
//     for(int i : arr) {
//         if(i%divisor == 0 && i/divisor != 0) unsorted_answer.push(i);
//     }
    
//     if(unsorted_answer.empty()) return {-1, };
    
//     result = quick(unsorted_answer);
    
//     while(!result.empty()){
//         answer.push_back(result.front());
//         result.pop();
//     }
    
    for(int i: arr){
        if(i%divisor == 0 && i/divisor != 0) answer.push_back(i);
    }
    
    if(answer.empty()) return {-1, };
    
    sort(answer.begin(), answer.end());
    
    return answer;
}