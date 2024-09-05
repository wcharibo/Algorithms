#include <string>
#include <vector>
#include <set>
#include <cstring>

using namespace std;
int answer = 0;
bool visited[10];
set<int> s;

bool check(string str) {
    int a = stod(str);
    if (a < 2) {
        return false;
    }
    for (int i = 2; i < a; i++) {
        if (a%i == 0) {
            return false;
        }
    }
    s.insert(a);
    return true;
}

void dfs(string numbers, string str) {
    if (str != "") {
        check(str);
    }
    for (int i = 0; i < numbers.length(); i++) {
        if (!visited[i]) {
            visited[i] = 1;
            dfs(numbers, str + numbers[i]);
            visited[i] = 0;
        }
    }
}

int solution(string numbers) {
    memset(visited, false, sizeof(visited));
    dfs(numbers, "");
    answer = s.size();
    s.clear();
    return answer;
}
