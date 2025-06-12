#include <vector>
#include <map>
#include <iostream>

using namespace std;

int need;
map<int,int> height;

int binary_search(int min_height, int max_height){
    int chain_saw = (min_height + max_height)/2;
    long long timber = 0;
    
    for(auto tree : height){
        long long height_tree = tree.first, num_tree = tree.second;
        if(height_tree > chain_saw) timber+=(height_tree-chain_saw)*num_tree;
    }
    
    if(timber == need) return chain_saw;
    else if(min_height == chain_saw){
        timber = 0;
        for(auto tree : height){
            int height_tree = tree.first, num_tree = tree.second;
            if(height_tree > chain_saw) timber+=(height_tree-(chain_saw+1))*num_tree;
        }
        
        if(timber >= need) return chain_saw+1;
        else return chain_saw;
    }
    else if(timber > need) return binary_search(chain_saw, max_height);
    else return binary_search(min_height, chain_saw);
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int tree, current = 0;
    cin>>tree>>need;
    
    for(int i = 0 ; i<tree; i++){
        int temp;
        cin>>temp;
        height[temp]++;
    }
    
    int max_height = (--height.end())->first;
    
    int result = binary_search(0, max_height);
    
    cout<<result<<endl;
}