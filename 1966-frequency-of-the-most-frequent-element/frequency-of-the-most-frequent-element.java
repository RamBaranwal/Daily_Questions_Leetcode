class Solution {
    public int maxFrequency(int[] nums, int k) {
        // this is sliding window
        Arrays.sort(nums);
        int ansFreHighest = 0;
        long sum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while((long)nums[right] * (right - left + 1) - sum > k){
                sum -= nums[left];
                left++;
            }

            ansFreHighest = Math.max(ansFreHighest, right - left + 1);
        }
        return ansFreHighest;
    }
}