class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int r = 0;
        int l = 0;
        int u = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'R'){
                r++;
            }
            else if(moves.charAt(i) == 'L'){
                l++;
            }
            else{
                u++;
            }
        }
        return u + Math.abs(l - r);
    }
}