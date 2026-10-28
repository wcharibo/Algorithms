import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        int minLength = 100;
        int maxLength = 0;
        
        for(String phone_num : phone_book){
            int size = phone_num.length();
            minLength = minLength > size ? size : minLength;
            maxLength = maxLength < size ? size : maxLength;
        }
        
        Arrays.sort(phone_book, (String i, String j) -> {
            return i.length() - j.length();
        });
        
        HashSet phoneNums = new HashSet<String>();
        int startPoint = 0;
        
        for(int i = minLength; i < maxLength + 1; i++){
            
            for(int j = startPoint; j < phone_book.length; j++){
                String phoneNum = phone_book[j];
                if(phoneNum.length() == i){
                    startPoint++;
                    if(phoneNums.add(phoneNum) == false){
                        return false;
                    }
                }else{
                    if(phoneNums.contains(phoneNum.substring(0,i))) return false;
                }
            }
        }
        
        return true;
    }
}