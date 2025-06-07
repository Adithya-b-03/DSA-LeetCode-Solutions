class Solution {
public:
    string clearStars(string s) {
        unordered_set<int> toRemove;
        unordered_map<char,vector<int>> mp;
        for(int i = 0 ; i < s.size() ; i++){
            if(s[i] == '*'){
                for(char j = 'a' ; j <= 'z' ; j++){
                    if(mp[j].size() != 0){
                        toRemove.insert(mp[j].back());
                        mp[j].pop_back();
                        break;
                    }
                }
            }
            else{
                mp[s[i]].push_back(i);
            }
        }
        string ans = "";
        for(int i = 0 ; i < s.size() ; i++){
            if(!toRemove.contains(i) && s[i] != '*'){
                ans += s[i];
            }
        }
        return ans;
    }
};