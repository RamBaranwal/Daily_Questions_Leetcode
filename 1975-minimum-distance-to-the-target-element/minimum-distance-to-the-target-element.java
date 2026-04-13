class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        int res = helper(nums, 0, target, min, start);
        return res;
    }
    private int helper(int[] nums, int index, int target, int min, int start){
        if(nums.length == index){
            return min;
        }
        if(nums[index] == target){
            min = Math.min(min, Math.abs(index - start));
        }
        return helper(nums, index + 1, target, min, start);
    }
}