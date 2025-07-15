class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n<3){
            return false;
        }
        int vow = 0;
        int con = 0;
        for(char c : word.toCharArray()){
            if(!Character.isDigit(c)&&!Character.isLetter(c)){
                return false;
            }
            else if(Character.isLetter(c)&&(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')){
                vow++;
            }
            else if(Character.isLetter(c)&&!(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')){
                con++;
            }
          
        }
          return (vow>=1 && con>=1);
    }
}