class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for(int x : nums){
            total += x;
        }
        int[] ans = new int[nums.length];
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            int right = total - nums[i];
            ans[i] = Math.abs(right - left);
            left += nums[i];
            total = right;
        }
        return ans;
    }
}