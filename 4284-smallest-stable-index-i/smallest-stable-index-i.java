class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0 ; i < nums.length; i++){
            int max = findMax(nums, 0, i);
            int min = findMin(nums, i, nums.length - 1);
            if(max - min <= k){
                return i;
            }
        }
        return -1;
    }

    private int findMax(int[] nums, int start, int mid){
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= mid; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private int findMin(int[] nums, int mid, int last){
        int min = Integer.MAX_VALUE;
        for(int i = mid; i <= last; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}