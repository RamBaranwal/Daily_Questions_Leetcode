class Solution {
    public int fib(int n) {
        int last = 0;
        int lastSecond = 1;
        for(int i = 0; i < n; i++){
            int curr = last + lastSecond;
            lastSecond = last;
            last = curr;
        }
        return last;
    }
}