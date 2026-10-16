class Solution {
    public int rob(int[] nums) {
        int n = nums.length + 1;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];
        for(int i = 3; i < n; i++){
            dp[i] = Math.max((nums[i - 1] + dp[i - 2]), nums[i - 1] + dp[i - 3]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}