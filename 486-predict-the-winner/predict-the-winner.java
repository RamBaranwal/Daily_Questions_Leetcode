class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
        }

        for(int len = 2; len <= nums.length; len++){
            for(int left = 0; left <= nums.length - len; left++){
                int right = left + len - 1;

                int takingLeft = nums[left] - dp[left + 1][right];
                int takingRight = nums[right] - dp[left][right - 1];

                dp[left][right] = Math.max(takingLeft, takingRight);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}