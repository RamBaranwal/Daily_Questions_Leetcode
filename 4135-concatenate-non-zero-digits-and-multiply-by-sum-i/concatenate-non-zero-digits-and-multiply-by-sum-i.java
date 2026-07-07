class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int rev = 0;
        while(n > 0){
            int last = n % 10;
            if(last != 0){
                rev = 10 * rev + last;
            }
            sum += last;
            n /= 10;
            // System.out.println(rev + ",,");
            // System.out.println(sum + "..");
        }
        
        int ori = 0;
        while(rev != 0){
            int last = rev % 10;
            ori = 10 * ori + last;
            rev /= 10;
        }
        return (long)ori * sum;
    }
}