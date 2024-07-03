#include <string>
#include <vector>
#include <sstream>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
    vector <int> space_arr;
    int space_cnt = 0;
    
    for(size_t a=0; a<s.size(); a++){
        char i = s[a];
        if(i==' '){
            space_cnt++;
            if(a==s.size()-1) space_arr.push_back(space_cnt);
        } 
        else{
            if(space_cnt!=0) space_arr.push_back(space_cnt);
            space_cnt = 0;
        }
    }
    
    istringstream iss(s);
    
    string temp;
    size_t space_arr_cnt = 0;
    
    for(size_t k=0; k<=space_arr.size(); k++){
        if(iss >> temp){
            for(size_t cnt = 0; cnt < temp.size(); ++cnt){
                int single_temp = int(temp[cnt]);
                if(65<=single_temp && single_temp<=90){ //대문자인 경우
                    single_temp+=32;    //소문자 변환
                    temp[cnt] = char(single_temp);
                }
            }
        
            int capital_temp = int(temp[0]);
            
            if(97<=capital_temp && capital_temp<=122){  //소문자인 경우
                capital_temp -= 32; //대문자 변환
                temp[0] = char(capital_temp);
            }
        
            answer.append(temp);
        }
        
        if(space_arr_cnt<space_arr.size()){
            for(int i=0; i<space_arr[space_arr_cnt]; i++) answer.append(" ");
            space_arr_cnt++;
        }
    }
    
    return answer;
}