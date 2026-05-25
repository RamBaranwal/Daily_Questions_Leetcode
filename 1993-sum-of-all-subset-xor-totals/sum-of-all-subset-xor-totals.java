class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int index, int currentXor){
        if(index == nums.length){
            return currentXor;
        }

        // include the element
        int include = helper(nums, index + 1, currentXor ^ nums[index]);

        // exclude rh
        int exclude = helper(nums, index + 1, currentXor);

        return include + exclude;
    }
}