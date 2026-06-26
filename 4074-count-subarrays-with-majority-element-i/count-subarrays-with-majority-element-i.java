class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        // taking target = +1;
        // taking non-target = -1;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == target){
                    sum++;
                }
                else{
                    sum--;
                }
                if(sum > 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}