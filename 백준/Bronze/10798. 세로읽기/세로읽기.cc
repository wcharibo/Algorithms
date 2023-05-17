#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    vector<string> arr;
    arr.resize(5);
    for (int i = 0; i < 5; i++)
    {
        getline(cin, arr[i]);
    }
    int max = arr[0].size();
    for (int i = 0; i < 5; i++)
    {
        if (max < arr[i].size()) max = arr[i].size();
    }

    for (int i = 0; i < max; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (arr[j][i])
            {
                cout<<arr[j][i];
            }
            
        }
    }
}
