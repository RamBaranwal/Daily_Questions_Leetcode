class Solution {
    public int missingInteger(int[] nums) {
        int maxSum = 0;
        int sum = nums[0];
        if(nums.length == 1){
            return nums[0] + 1;
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1){
                sum += nums[i];
                maxSum = Math.max(sum, maxSum);
            }
            else{
                break;
            } 
        }
        maxSum = Math.max(maxSum, nums[0]);
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        while(set.contains(maxSum)){
            maxSum++;
        }
        return maxSum; 
    }
}