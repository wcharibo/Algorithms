#include <string>
#include <vector>
#include <sstream>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
    int temp;
    
    istringstream iss(s);
    ostringstream oss;
    
    vector<int> numbers;
    while (iss >> temp) numbers.push_back(temp);
    
    int min = numbers[0];
    int max = numbers[0];
    for (int num : numbers) {
        if(num > max) max = num;
        else if(num < min) min = num;
    }
    
    oss << min << ' '<< max;
    answer.append(oss.str());
    
    return answer;
}