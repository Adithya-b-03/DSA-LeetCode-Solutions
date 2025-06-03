class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
     int n = status.length;
     int tot = 0;
     boolean hasBox[] = new boolean[n];
     boolean hasKey[] = new boolean[n];
     boolean visited[] = new boolean[n];
     Queue <Integer> q = new LinkedList<>();
     for(int box : initialBoxes){
        hasBox[box] = true;
        q.offer(box);
     }   
     while(!q.isEmpty()){
        int box = q.poll();
        if(status[box]==0 && !hasKey[box]){
            continue;
        }
        if(visited[box] == true){
            continue;
        }
        visited[box] = true;
        tot = tot + candies[box];
        for(int b : keys[box]){
            hasKey[b] = true;
            if(hasBox[b]){
                q.offer(b);
            }
        }
        for(int ib : containedBoxes[box]){
            hasBox[ib] = true;
            q.offer(ib);
        }
     }
     return tot;
    }
}