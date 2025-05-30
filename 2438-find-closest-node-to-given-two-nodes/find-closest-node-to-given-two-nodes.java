class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int d1[] = new int[n];
        int d2[] = new int[n];
        Arrays.fill(d1,-1);
        Arrays.fill(d2,-1);
        
        d1[node1] = 0;
        d2[node2] = 0;

        int d = 0;
        int i = node1;

        while(true){
            d1[i] = d++;
            i = edges[i];
            if(i==-1 || d1[i] != -1){
                break;
            }
        } 

        d = 0;
        i = node2;

        while(true){
            d2[i] = d++;
            i = edges[i];
            if(i==-1 || d2[i]!=-1){
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;

        for(i = 0 ; i < n ; i++){
            if(d1[i]==-1 || d2[i]==-1) continue;

            if(Math.max(d1[i],d2[i]) < min){
                min = Math.max(d1[i],d2[i]);
                ans = i;
            }
        }
        return ans;
    }
}