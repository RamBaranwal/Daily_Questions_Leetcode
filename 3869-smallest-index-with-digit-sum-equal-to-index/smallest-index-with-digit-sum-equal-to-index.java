class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int sum = digitSum(nums[i]);
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
    private int digitSum(int n){
        int sum = 0;
        int temp = n;
        while(temp > 0){
            int rem = temp % 10;
            sum += rem;
            temp /= 10;
        }
        return sum;
    }
}