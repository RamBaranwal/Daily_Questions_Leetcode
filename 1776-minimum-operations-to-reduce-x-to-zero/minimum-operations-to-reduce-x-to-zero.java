class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum == x){
            return nums.length;
        }
        int left = 0;
        int maxLength = -1;
        int target = sum - x;
        int currSum = 0;
        for(int right = 0; right < nums.length; right++){
            currSum += nums[right];
            while(currSum > target && left < right){
                currSum -= nums[left];
                left++;
            }
            if(currSum == target){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        if(maxLength == -1){
            return maxLength;
        }
        return nums.length - maxLength;
    }
}