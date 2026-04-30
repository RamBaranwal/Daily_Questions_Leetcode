class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length - 1];
        int n = GCD(a, b);
        return n;
    }
    private int GCD(int a, int b){
        if(a == 0){
            return b;
        }
        return GCD(b % a, a);
    }
}