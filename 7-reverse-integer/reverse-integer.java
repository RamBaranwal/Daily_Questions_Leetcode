class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        String str = String.valueOf(Math.abs((long)x));
        String reverse = new StringBuilder(str).reverse().toString();
        long res = Long.parseLong(reverse);
        if(negative){
            res = -res;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
}