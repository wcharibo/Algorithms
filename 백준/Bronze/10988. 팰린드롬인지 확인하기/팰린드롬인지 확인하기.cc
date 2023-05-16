#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
   string word;
   cin>>word;

   for (int i = 0; i < word.size()/2; i++)
   {
        if (word[i]==word[word.size()-i-1])
        {
            continue;
        }
        else{
            cout<<0;
            return 0;
        }
   }
   cout<<1;
   return 0;
}