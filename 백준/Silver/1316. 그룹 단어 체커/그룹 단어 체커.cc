#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    int string_num, result=0;
    cin>>string_num;
    
    vector <string> words;
    words.resize(string_num);

    for (int i = 0; i < string_num; i++)
    {
        cin>>words[i];
    }
    for (int i = 0; i < string_num; i++)
    {   
        vector <int> alphabet;  
        alphabet.resize(26);
        int serial_flag=0;
        char flag=words[i][0];
        for (int j = 0; j < words[i].size(); j++)
        {
            if (alphabet[int(words[i][j])-97]==0)
            {
                alphabet[int(words[i][j])-97]=1;
                flag=words[i][j];
            }
            else if(alphabet[int(words[i][j])-97]==1 && flag==words[i][j]){

            }
            else{
                serial_flag=1;
            }
        }

        if (serial_flag==0)
        {
            result++;
        }
    }
    cout<<result;

}