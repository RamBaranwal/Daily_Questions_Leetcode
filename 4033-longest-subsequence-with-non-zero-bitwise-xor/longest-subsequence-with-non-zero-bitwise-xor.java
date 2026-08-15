class Solution {
    public int longestSubsequence(int[] nums) {
        boolean nonNumZero = false;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
            if(num != 0){
                nonNumZero = true;
            }
        }

        if(xor != 0){
            return nums.length;
        }

        if(xor == 0 && nonNumZero){
            return nums.length - 1;
        }
        
        return 0;
    }
}