class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxCount = 1;
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            int count = 1;
            if((nums[i] & nums[i - 1]) == 0){
                for(int k = i - 1; k >= j; k--){
                    if((nums[k] & nums[i]) == 0){
                        count++;
                    }
                    else{
                        j = k + 1;
                        break;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
            else{
                j = i;
            }
        }
        return maxCount;
    }
}