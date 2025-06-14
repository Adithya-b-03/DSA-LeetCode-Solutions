class Solution {
    public static void findCombinations(int i,int sum, int[] arr, List<List<Integer>> ans,List<Integer> res){
        if(i == arr.length){
            if(sum == 0){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        if(arr[i] <= sum){
            res.add(arr[i]);
            findCombinations(i,sum-arr[i],arr,ans,res);
            res.remove(res.size()-1);
        }
        findCombinations(i+1,sum,arr,ans,res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,target,candidates,ans,new ArrayList<>());
        return ans; 
    }
}