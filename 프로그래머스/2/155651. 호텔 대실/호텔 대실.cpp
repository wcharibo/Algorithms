#include <string>
#include <vector>
#include <algorithm>

using namespace std;

//대소비교를 용이하게 하기위해 시간을 모두 분으로 환산하고 오름차순으로 정렬한다. 방을 사용하기 시작하는 시간이면 1 끝나는 시간이면 -1로 저장하고 정렬했으니까 어떠한 예약이든 합은 0이다. 하지만 최대로 몰리는 시간에 필요한 최소한의 방의 수가 필요한 것이므로 방이 가장 많이 열려있는 시점에 방의 개수를 기록하면 된다.  

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    vector<pair<int,int>> reserved_time;    //first=start, second=end, convert to minute
    for(int i=0; i<book_time.size(); i++){
        reserved_time.push_back({stoi(book_time[i][0].substr(0, 2)) * 60 + stoi(book_time[i][0].substr(3, 2)), 1}); // Start time, mark as 1
        reserved_time.push_back({stoi(book_time[i][1].substr(0, 2)) * 60 + stoi(book_time[i][1].substr(3, 2)) + 10, -1}); // End time, mark as -1, sum 10min to clean room
    }
    
    sort(reserved_time.begin(), reserved_time.end());
    
    int max_opened_room = 0;
    int cur_opened_room = 0;
    
    for(int i=0; i<reserved_time.size(); i++){
        cur_opened_room += reserved_time[i].second;
        max_opened_room = max(max_opened_room, cur_opened_room);
    }
    
    return max_opened_room;
}