#include <iostream>
#include <vector>

using namespace std;

int main() {
    int case_num;
    cin>>case_num;
    vector <int> case_arr(case_num);
    for(int i=0; i<case_num; i++){
        cin>>case_arr[i];
    }
    vector <pair <int, int> > fib_arr;
    fib_arr.push_back(make_pair(1,0));
    fib_arr.push_back(make_pair(0,1));
    int max = case_arr[0];
    for(int i=1; i<case_num; i++){
        if(max<case_arr[i]) max=case_arr[i];
    }

    for(int i = 2; i<=max; i++){
        auto p = make_pair(fib_arr[i-2].first+fib_arr[i-1].first,
        fib_arr[i-2].second+fib_arr[i-1].second);
        fib_arr.push_back(p);
    }
    
    for(int i=0; i<case_num; i++){
        cout<<fib_arr[case_arr[i]].first<<' '<<
        fib_arr[case_arr[i]].second<<endl;
    }
}