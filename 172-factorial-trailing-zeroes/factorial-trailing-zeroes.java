class Solution {
    public int trailingZeroes(int n) {
        // formula
        // n / 5 and count the quetionet till n != 0
        // this is the trick to know the trialing zero 
        int count = 0;
        while( n > 0){
            n = n / 5;
            count += n;
        }
        return count;
    }
}