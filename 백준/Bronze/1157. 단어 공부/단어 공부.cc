#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    string word;
    vector <int> arr;
    arr.resize(27);
    cin>>word;

    for (int i = 0; i <= word.size(); i++)
    {   
        if (int(word[i])>=97)
        {   
            arr[int(word[i])-97]+=1;
        }
        else{
            arr[int(word[i])-65]+=1;
        }
    }
    int max=0;
    int flag=0;
    for (int i = 1; i < 26; i++)
    {   
        if (arr[i]!=0&&arr[i]==arr[max])
        {
            flag=1;
        }
        else if (arr[i]>arr[max])
        {
            max=i;
            flag=0;
        }
    }

    if (flag==1)
    {
        cout<<'?';
        return 0;
    }
    
    cout<<char(max+65);
}

