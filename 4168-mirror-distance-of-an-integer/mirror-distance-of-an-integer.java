class Solution {
    public int mirrorDistance(int n) {
        int reverse = rev(n);
        return Math.abs(n - rev(n));
    }
    private int rev(int n){
        int digit = 0;
        while(n > 0){
            int rem = n % 10;
            digit = digit * 10 + rem;
            n = n / 10;
        }
        return digit;
    }
}