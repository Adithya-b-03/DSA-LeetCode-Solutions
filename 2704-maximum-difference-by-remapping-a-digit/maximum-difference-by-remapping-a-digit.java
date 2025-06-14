class Solution {
    public int minMaxDifference(int num) {
        String n = num + "";
        char maxdig = 'a';
        for(int i = 0 ; i < n.length() ; i++){
            if(n.charAt(i) != '9'){
                maxdig = n.charAt(i);
                break;
            }
        }
        int max = Integer.parseInt(n.replace(maxdig,'9'));
        char mindig = n.charAt(0);
        int min = Integer.parseInt(n.replace(mindig,'0'));
        return max-min;
    }
}