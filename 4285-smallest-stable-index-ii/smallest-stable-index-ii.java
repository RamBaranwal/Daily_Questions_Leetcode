class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];

        maxArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxArr[i - 1] > nums[i]){
                maxArr[i] = maxArr[i - 1];
            }
            else{
                maxArr[i] = nums[i];
            }
        }

        minArr[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(minArr[i + 1] < nums[i]){
                minArr[i] = minArr[i + 1];
            }
            else{
                minArr[i] = nums[i];
            }
        }

        for(int i = 0; i < minArr.length; i++){
            if(maxArr[i] - minArr[i] <= k){
                return i;
            }
        }
        return -1;
    }
}