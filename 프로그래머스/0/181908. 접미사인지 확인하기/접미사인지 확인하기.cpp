#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string my_string, string is_suffix) {    
    if(my_string.size() < is_suffix.size())
    {
        return 0;
    }
    cout<< my_string.substr(my_string.size() - is_suffix.size(), 1);
    return my_string.substr(my_string.size() - is_suffix.size()) == is_suffix;
}