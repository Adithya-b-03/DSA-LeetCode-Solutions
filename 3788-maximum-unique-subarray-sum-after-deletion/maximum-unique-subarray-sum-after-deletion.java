class Solution {
    public int maxSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        Integer arr[] = set.toArray(new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());
        int rs = Integer.MIN_VALUE;
        int s = 0;
        for(int i = 0 ; i < arr.length ; i++){
            s += arr[i];
            rs = Math.max(rs,s);

        }
        return rs;
    }
}