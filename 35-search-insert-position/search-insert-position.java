class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int ans = nums.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                ans = mid;
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}