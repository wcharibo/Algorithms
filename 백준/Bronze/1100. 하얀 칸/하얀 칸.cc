#include <iostream>

using namespace std;

int main() {
    char arr[8][8];
    int count = 0;
    // User input
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            cin >> arr[i][j];
        }
    }

    // Count number of 'F' characters
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if(i%2==0){
                if(j%2==0&&arr[i][j]=='F')count++;             
            }
            else if(i%2==1){
                if(j%2==1&&arr[i][j]=='F')count++;               
            }
            else return 0;
            }
        } 
    cout<<count;
 return 0;
   
    }