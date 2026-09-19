class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int j = nums.length - 1;

        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if(i >= 0){
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
        }

        if(i >= 0){
            swap(nums, i, j);
            reverse(nums, i + 1);
        }
        else{
            reverse(nums, 0);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int last = nums.length - 1;
        while(start <= last){
            swap(nums, start, last);
            start++;
            last--;
        }
    }
}