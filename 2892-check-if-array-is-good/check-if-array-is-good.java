class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= nums[nums.length - 1]) return false;
        for(int i = nums.length - 2; i > 0; i--){
            if(nums[i] == nums[i - 1]){
                return false;
            }
        }
        return true;
    }
}