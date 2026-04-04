class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0; i < k; i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] = nums[index] * multiplier;
        }
        return nums;
    }
}