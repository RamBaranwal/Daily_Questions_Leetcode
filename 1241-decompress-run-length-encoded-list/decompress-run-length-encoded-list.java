class Solution {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for(int i = 0; i < nums.length; i += 2){
            size += nums[i];
        }

        int indx = 0;
        int[] ans = new int[size];
        for(int i = 0; i < nums.length; i += 2){
            Arrays.fill(ans, indx, indx+nums[i], nums[i + 1]);
            indx += nums[i];
        }
        return ans;
    }
}