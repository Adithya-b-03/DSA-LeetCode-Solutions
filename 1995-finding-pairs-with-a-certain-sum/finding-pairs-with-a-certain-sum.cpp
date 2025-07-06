class FindSumPairs {
    vector<int> a1;
    vector<int> a2;
    unordered_map<int,int> mp;
public:
    FindSumPairs(vector<int>& nums1, vector<int>& nums2) {
        a1 = nums1;
        a2 = nums2;
        for(auto e : a2){
            mp[e]++;
        }
    }
    void add(int index, int val) {
        mp[a2[index]]--;
        a2[index] += val;
        mp[a2[index]]++;
    }
    int count(int tot) {
        int res = 0 ;
        for(auto e : a1){
            if(mp.count(tot-e)){
                res += mp[tot-e];
            }
        }   
        return res;
    }
};

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs* obj = new FindSumPairs(nums1, nums2);
 * obj->add(index,val);
 * int param_2 = obj->count(tot);
 */