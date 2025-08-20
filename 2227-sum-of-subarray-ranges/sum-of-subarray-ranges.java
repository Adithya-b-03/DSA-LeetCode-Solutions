import java.util.*;

class Solution {
    public int[] nse(int[] arr){
        int n = arr.length;
        int ns[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            ns[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return ns;
    }
    public int[] nge(int[] arr){
        int n = arr.length;
        int ng[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            ng[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return ng;
    }
    public int[] pse(int[] arr){
        int n = arr.length;
        int ps[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }
            ps[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return ps;
    }
    public int[] pge(int[] arr){
        int n = arr.length;
        int pg[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                s.pop();
            }
            pg[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return pg;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ps = pse(arr);
        int[] ns = nse(arr);

        long tot = 0;
        for(int i = 0 ; i < n ; i++){
            long l = i - ps[i];
            long r = ns[i] - i;
            tot += (long)arr[i] * l * r;
        }
        return tot;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] pg = pge(arr);
        int[] ng = nge(arr);

        long tot = 0;
        for(int i = 0 ; i < n ; i++){
            long l = i - pg[i];
            long r = ng[i] - i;
            tot += (long)arr[i] * l * r;
        }
        return tot;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}
