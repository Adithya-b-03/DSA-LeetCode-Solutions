class Solution {
    public static void f(int ind,int[] nums,List<List<Integer>> ans,List<Integer> res){
        ans.add(new ArrayList<>(res));
        for(int i = ind ; i < nums.length ; i++){
            res.add(nums[i]);
            f(i+1,nums,ans,res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = 1<<nums.length;
        // f(0,nums,ans,new ArrayList<>());
        for(int i = 0 ; i < n ; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0 ; j < nums.length ; j++){
                if((i & (1<<j))!=0){
                    l.add(nums[j]);
                }
            }
            ans.add(l);
        }
        return ans;
    }
}