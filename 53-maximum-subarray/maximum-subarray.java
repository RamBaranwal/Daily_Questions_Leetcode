class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxCurr = new int[nums.length];
        int ans = nums[0];
        if(nums.length == 1) return nums[0];
        maxCurr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxCurr[i] = Math.max(nums[i], maxCurr[i - 1] + nums[i]);
            ans = Math.max(ans, maxCurr[i]);
        }
        return ans;
    }
}