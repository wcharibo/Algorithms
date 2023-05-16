#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    vector <int> arr1, arr2;
    int rowNum, colNum;

    cin>> rowNum >>colNum;
    arr1.resize(rowNum*colNum);
    arr2.resize(rowNum*colNum);

    for (int i = 0; i < rowNum*colNum; i++)
    {
        cin>>arr1[i];
    }
    for (int i = 0; i < rowNum*colNum; i++)
    {
        cin>>arr2[i];
        arr1[i]+=arr2[i];
    }
    for (int i = 0; i < rowNum*colNum; i++)
    {
        cout<<arr1[i];
        if ((i+1)%3==0 && i!=8)
        {
            cout<<endl;
        }
        else cout<<' ';
        
    }
    
}

