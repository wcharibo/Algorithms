#include <iostream>
#include <queue>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long A, B, min_cal = 1000000000;
    cin >> A >> B;

    queue<pair<int, int>> queue_BFS;
    queue_BFS.push({A,0});
    
    while(!queue_BFS.empty()){
        long long current = queue_BFS.front().first, cnt_cal = queue_BFS.front().second;
        queue_BFS.pop();

        if(B == current) min_cal = min(min_cal, cnt_cal);

        long long pos_1 = current*2, pos_2 = current * 10 + 1;

        if(B >= pos_1) queue_BFS.push({pos_1, cnt_cal + 1});
        if(B >= pos_2) queue_BFS.push({pos_2, cnt_cal + 1});
    }

    if(min_cal == 1000000000) cout << -1;
    else cout << min_cal+1;


    return 0;
}