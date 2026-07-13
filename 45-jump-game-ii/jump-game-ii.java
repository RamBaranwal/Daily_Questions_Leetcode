class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int currReach = 0;
        int jumps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxReach = Math.max(maxReach, nums[i] + i);
            if(i == currReach){
                jumps++;
                currReach = maxReach;
            }
        }
        return jumps;
    }
}