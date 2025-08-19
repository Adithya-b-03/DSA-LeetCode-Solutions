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
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ps[] = new int[n];
        int ns[] = new int[n];
        ps = pse(arr);
        ns = nse(arr);
        int mod = (int)(1e9+7);
        long tot = 0;
        for(int i = 0 ; i < n ; i++){
            int l = i - ps[i];
            int r = ns[i] - i;
            tot = (tot + (long)arr[i]*l*r)%mod;
        }
        return (int)tot;
    }
}