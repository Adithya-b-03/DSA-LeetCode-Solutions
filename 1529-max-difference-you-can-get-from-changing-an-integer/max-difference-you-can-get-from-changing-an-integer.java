class Solution {
    public int maxDiff(int num) {
       String original = Integer.toString(num);
       int a = num;
       for(int i = 0 ; i < original.length() ; i++){
            if(original.charAt(i) != '9'){
                a = Integer.parseInt(original.replace(original.charAt(i),'9'));
                break;
            }
       } 
       char first = original.charAt(0);
       int b = num;
       if(first != '1'){
            b = Integer.parseInt(original.replace(first,'1'));
       }
       else{
            for(int i = 1 ; i < original.length() ; i++){
                if(original.charAt(i) != '0' && original.charAt(i) != '1'){
                    b = Integer.parseInt(original.replace(original.charAt(i),'0'));
                    break;
                }
            }
       }
       return a-b;
    }
}