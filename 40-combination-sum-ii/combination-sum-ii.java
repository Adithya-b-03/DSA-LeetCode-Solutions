class Solution {
    public static void findCombinations(int ind, int[] arr, int sum, List<List<Integer>> ans, List<Integer> res){
        if(sum == 0){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = ind ; i < arr.length ; i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > sum) break;
            res.add(arr[i]);
            findCombinations(i+1,arr,sum-arr[i],ans,res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}