class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int temp = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 1){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            else{
                if(temp < k){
                    maxLen = Math.max(maxLen, right - left + 1);
                    temp++;
                }
                else{
                    while(nums[left] != 0){
                        left++;
                    }
                    left++;
                    temp++;
                }
            }
        }
        return maxLen;
    }
}