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
        f(0,nums,ans,new ArrayList<>());
        return ans;
    }
}