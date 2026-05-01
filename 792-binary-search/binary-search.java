class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }
    private int helper(int[] nums, int s, int e, int target){
        if(s > e){
            return -1;
        }
        int mid = s + (e - s) / 2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > target){
            return helper(nums, s, mid - 1, target);
        }
        else{
            return helper(nums, mid + 1, e, target);
        }
    }
}