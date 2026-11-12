class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int maxIncLen = 1;
        int maxDecLen = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                incLen++;
            }
            else{
                maxIncLen = Math.max(maxIncLen, incLen);
                incLen = 1;
            }
            if(nums[i] < nums[i - 1]){
                decLen++;
            }
            else{
                maxDecLen = Math.max(maxDecLen, decLen);
                decLen = 1;
            }
        }
        maxIncLen = Math.max(maxIncLen, incLen);
        maxDecLen = Math.max(maxDecLen, decLen);
        return Math.max(maxIncLen, maxDecLen);
    }
}