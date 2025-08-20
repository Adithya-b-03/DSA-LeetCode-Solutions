class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> l = new ArrayList<>();
        int n = asteroids.length;
        for(int i = 0 ; i < n ; i++){
            if(asteroids[i] > 0){
                l.add(asteroids[i]);
            }
            else{
                while(l.size() != 0 && l.get(l.size()-1) > 0 && l.get(l.size()-1) < Math.abs(asteroids[i])){
                    l.remove(l.size()-1);
                }
                if(l.size() != 0 && l.get(l.size()-1) == Math.abs(asteroids[i])){
                    l.remove(l.size()-1);
                }
                else if(l.size() == 0 || l.get(l.size()-1) < 0){
                    l.add(asteroids[i]);
                }
            }     
        }
        int a[] = new int[l.size()];
        for(int i = 0 ; i < l.size() ; i++){
            a[i] = l.get(i);
        }
        return a;
    }
}