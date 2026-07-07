class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while(n > 0){
            int lastDigit = n % 10;
            if(lastDigit != 0){
                sb.append(lastDigit);
            }
            sum += lastDigit;
            n /= 10;
        }
        if(sb.isEmpty()){
            return 0;
        }
        sb.reverse();
        String s = sb.toString();
        long l = Long.parseLong(s);
        return l * sum;
    }
}