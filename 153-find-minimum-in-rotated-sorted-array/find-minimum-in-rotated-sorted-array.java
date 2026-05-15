class Solution {
    public int findMin(int[] nums) {
        int pivot = pivot(nums);
        if(pivot == -1){
            return nums[0];
        }
        else{
            return nums[pivot + 1];
        }
    }
    private int pivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(start < mid && nums[mid - 1] > nums[mid]){
                return mid - 1;
            }
            if(end > mid && nums[mid + 1] < nums[mid]){
                return mid;
            }
            if(nums[start] < nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}