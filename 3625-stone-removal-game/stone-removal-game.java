class Solution {
    public boolean canAliceWin(int n) {
        for(int i = 10; i >= 0; i--){
            n = n - i;
            if(n < 0){
                if(i % 2 == 0){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return true;
    }
}