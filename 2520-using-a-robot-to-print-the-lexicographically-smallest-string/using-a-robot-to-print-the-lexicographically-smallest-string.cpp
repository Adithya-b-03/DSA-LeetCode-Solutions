class Solution {
public:
    string robotWithString(string s) {
        int n = s.size();
        unordered_map<char,int> cnt;
        for(auto c: s){
            cnt[c]++;
        }
        stack<char> st;
        char min = 'a';
        string p = "";
        for(auto c: s){
            st.push(c);
            cnt[c]--;
            while(min !='z' && cnt[min]==0){
                min++;
            }
            while(!st.empty() && st.top()<=min){
                p += st.top();
                st.pop();
            }
        }
        return p;
    }
};