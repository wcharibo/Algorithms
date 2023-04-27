#include <iostream>
#include <cmath>
using namespace std;

int getNumStick(int length);

int main() {
    int length = 0, num = 0;
    cin >> length;
    num = getNumStick(length);
    cout << num;
}

int getNumStick(int length) {
    int cnt=0;
    for (int i = 6; i >= 0; i--) {
        if (length == 0) break;
        else if (length == int(pow(2, i))) {
            length = length - int(pow(2, i));
            cnt++;
        }
        else if (length != length % int(pow(2,i))) {
            length = length - int(pow(2, i));
            cnt++;
        }
    }
    return cnt;
}