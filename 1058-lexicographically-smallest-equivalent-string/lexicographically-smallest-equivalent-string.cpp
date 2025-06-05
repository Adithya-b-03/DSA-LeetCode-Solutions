class Solution {
    int parent[26];
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void unionFind(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return;
        }
        if(pa<pb){
            parent[pb] = pa;
        }
        else{
            parent[pa] = pb;
        }
    }
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < s1.size() ; i++){
            unionFind(s1[i]-'a',s2[i]-'a');
        }
        string ans = "";
        for(int i = 0 ; i < baseStr.size() ; i++){
            ans += (char)(find(baseStr[i]-'a')+'a');
        }
        return ans;
    }
};