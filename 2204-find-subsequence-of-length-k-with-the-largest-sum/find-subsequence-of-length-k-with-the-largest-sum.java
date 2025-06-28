public class Elt{
    int num;
    int index;
    Elt(int num,int index){
        this.num = num;
        this.index = index;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Elt> pq = new PriorityQueue<>((a,b)->a.num-b.num);
        for(int i = 0 ; i < nums.length ; i++){
            pq.offer(new Elt(nums[i],i));
            if(pq.size() > k){
                pq.poll();
            }
        }
        Set<Integer> ind = new HashSet<>();
        while(!pq.isEmpty()){
            Elt e = pq.poll();
            ind.add(e.index);
        }
        int ans[] = new int[k];
        int p = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(ind.contains(i)){
                ans[p] = nums[i];
                p++;
            }
        }
        return ans;
    }
}