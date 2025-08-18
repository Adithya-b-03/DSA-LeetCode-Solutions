class Solution {
    public int getInd(int arr[],int k){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==k){
                return i;
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ng[] = new int[nums2.length];
        Stack<Integer> s = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()==true){
                ng[i] = -1;
            }
            else{
                ng[i] = s.peek();
            }
            s.push(nums2[i]);
        }
        int ng1[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            int ind = getInd(nums2,nums1[i]);
            if(ind!=-1){
                ng1[i]=ng[ind];
            }
            else{
                ng1[i]=-1;
            }
        }
        return ng1;
    }
   
}