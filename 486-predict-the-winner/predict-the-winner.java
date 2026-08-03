class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];

        return solve(nums, dp, 0, nums.length - 1) >= 0;
    }
    private int solve(int[] nums, Integer[][] dp, int left, int right){
        if(left == right){
            return nums[left];
        }

        if(dp[left][right] != null){
            return dp[left][right];
        }
        
        int leftTaken = nums[left] - solve(nums, dp, left + 1, right);
        int rightTaken = nums[right] - solve(nums, dp, left, right - 1);

        return dp[left][right] = Math.max(leftTaken, rightTaken);
    }
}