#include <iostream>
#include <queue>

using namespace std;

int result;

void cal(pair <int, int> x, queue <pair <int, int> > &q);

int main() {
    int start;
    queue <pair <int, int> > order;
    cin>>start;
    
    order.push(make_pair(start, 0));
    
    cal(order.front(), order);
    
    cout<<result;
}

void cal(pair <int, int> x, queue <pair <int, int> > &q){
    if(x.first==1){
        result=x.second;
        return;
    }
    x.second++;
    if(x.first%3==0) q.push(make_pair(x.first/3, x.second));
    if(x.first%2==0) q.push(make_pair(x.first/2, x.second));
    q.push(make_pair(x.first-1, x.second));
    q.pop();
    cal(q.front(), q);
}