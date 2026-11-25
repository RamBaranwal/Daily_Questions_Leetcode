class Solution {
    private int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int LCM(int a, int b) {
        return (a / GCD(a, b)) * b;
    }
    public int maxLength(int[] nums) {
        int maxLen = 0;
        for (int left = 0; left < nums.length; left++) {
            long pro = 1;
            int gcd = 0;
            long lcm = 1;
            for (int right = left; right < nums.length; right++) {
                int num = nums[right];
                pro *= num;
                gcd = GCD(gcd, num);
                lcm = LCM((int) lcm, num);
                if (pro == lcm * gcd) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }
        return maxLen;
    }
}