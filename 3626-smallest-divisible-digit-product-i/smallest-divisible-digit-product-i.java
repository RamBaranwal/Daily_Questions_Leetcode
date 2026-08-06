class Solution {
    private boolean isDivisible(int n, int m){
        int mul = 1;
        while(n != 0){
            int rem = n % 10;
            mul *= rem;
            n /= 10;
        }
        return mul % m == 0;
    }
    public int smallestNumber(int n, int t) {
        for(int i = 0; i <= 10; i++){
            if(isDivisible(n + i, t)){
                return n + i;
            }
        }
        return n;
    }
}