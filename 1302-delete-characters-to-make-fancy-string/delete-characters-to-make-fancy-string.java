class Solution {
    public String makeFancyString(String s) {
        int f = 1;
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == res.charAt(res.length()-1)){
                f++;
                if(f<3){
                    res.append(s.charAt(i));
                }
            }   
            else{
                res.append(s.charAt(i));
                f = 1;
            }
        }
        return res.toString();
    }
}