class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int num : stones){
            if(num % 3 == 0){
                c0++;
            }
            else if(num % 3 == 1){
                c1++;
            }
            else{
                c2++;
            }
        }
        return (c0 % 2 == 0 && c1 > 0 && c2 > 0) || (c0 % 2 == 1 && Math.abs(c1 - c2) > 2);
    }
}