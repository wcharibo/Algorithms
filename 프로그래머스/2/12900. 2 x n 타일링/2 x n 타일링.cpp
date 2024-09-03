#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> tiles = {1,2};
    for(int i = 2; i < n; i++) tiles.push_back((tiles[i-2]%1000000007 + tiles[i-1]%1000000007)%1000000007);
    
    return tiles[n-1];
}