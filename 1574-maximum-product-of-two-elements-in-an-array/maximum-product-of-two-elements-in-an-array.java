class Solution {
    public int maxProduct(int[] nums) {
        int firstLargest = findLargest(nums);
        int secondLargest = findLargest(nums);
        
        return (firstLargest - 1) * (secondLargest - 1); 
    }
    private int findLargest(int[] nums){
        int max = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        nums[index] = 0;
        return max;
    }
}