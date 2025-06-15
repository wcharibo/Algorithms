#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

vector<vector<int>> connections;
vector<int> visited;
vector<int> new_people;

void dfs(int start){
    vector<int> connected;
    visited[start] = 1;
    
    for(int i = 1; i < connections[start].size(); i++){
        if(i != start && visited[i] == 0 && connections[start][i] == 1){
            new_people.push_back(i);
            dfs(i);
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int num_people, num_party, num_people_knew, lies = 0;
    
    cin>>num_people>>num_party;
    cin>>num_people_knew;
    
    unordered_set<int> people_knew;
    vector<vector<int>> parties;
    connections.resize(num_people+1, vector<int> (num_people+1, 0));
    visited.resize(num_people+1, 0);
    
    for(int i = 0; i< num_people_knew; i++){
        int temp;
        cin>>temp;
        people_knew.insert(temp);
    }
    
    
    for(int party = 0; party < num_party; party++){
        int num_attender;
        cin>>num_attender;
        
        bool lie_enable = true;
        vector<int> party_attender(num_attender, 0);
        
        for(int &attender : party_attender) cin>>attender;
        
        for(auto start = party_attender.begin(); start != (party_attender.end()-1); start++){
            for(auto end = start+1; end != party_attender.end(); end++){
                connections[*start][*end] = 1;
                connections[*end][*start] = 1;
            }
        }
        
        parties.push_back(party_attender);
    }
    
    for(int known : people_knew) dfs(known);
    
    for(int new_person : new_people) people_knew.insert(new_person);
    
    for(vector<int> party : parties){
        bool pos_lie = true;
        for(int attender : party) if(people_knew.find(attender) != people_knew.end()) pos_lie = false;
        
        if(pos_lie) lies++;
    }
    
    cout<<lies<<endl;
}
