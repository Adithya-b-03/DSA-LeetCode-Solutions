class Solution {
    public static String giveStr(int x){
        String t = x+"";
        char[] c = t.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
    public boolean reorderedPowerOf2(int n) {
        String tar = giveStr(n);
        for(int i = 0 ; i < 31 ; i++){
            if(giveStr(1<<i).equals(tar)){
                return true;
            }
        }
        return false;
    }
}