#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max();

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int vertex, edge, start;
    cin >> vertex >> edge;

    vector<vector<pair<int, int>>> graph(vertex + 1);
    vector<int> result(vertex + 1, INF);
    vector<bool> visited(vertex + 1, false);

    cin >> start;
    result[start] = 0;

    for (int i = 0; i < edge; i++) {
        int x, y, w;
        cin >> x >> y >> w;
        graph[x].push_back({y, w});
    }

    // Min-heap: {거리, 정점}
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    pq.push({0, start});

    while (!pq.empty()) {
        int dist = pq.top().first;
        int now = pq.top().second;
        pq.pop();

        if (visited[now]) continue;
        visited[now] = true;

        for (auto& [next, weight] : graph[now]) {
            if (result[next] > dist + weight) {
                result[next] = dist + weight;
                pq.push({result[next], next});
            }
        }
    }

    for (int i = 1; i <= vertex; i++) {
        if (result[i] == INF) cout << "INF\n";
        else cout << result[i] << '\n';
    }

    return 0;
}
