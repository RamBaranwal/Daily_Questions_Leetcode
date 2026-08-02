class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];
        return solve(piles, dp, 0, n - 1) > 0;
    }
    private int solve(int[] piles, Integer[][] dp, int left, int right){
        if(left == right){
            return piles[left];
        }

        if(dp[left][right] != null){
            return dp[left][right];
        }

        int takeLeft = piles[left] - solve(piles, dp, left + 1, right);
        int takeRight = piles[right] - solve(piles, dp, left, right - 1);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }
}