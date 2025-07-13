class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        int j = 0;
        int ans = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        for(int i = 0 ; i < n ; i++){
            while(j<m && players[i]>trainers[j]){
                j++;
            }
            if(j<m){
                ans++;
                j++;
            }
        }
        return ans;
    }
}