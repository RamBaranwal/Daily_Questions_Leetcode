class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f = 0;
        // find the f(0)
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;
        // now we have to find the each rotation 
        // formula when we increase the index by +1 its like 
        // (i+1)×nums[i] - i×nums[i] = nums[i]
        // but for last index it will be multiply by * 0
        // so F(k) = F(k-1) + sum - n × nums[n-k]

        for(int k = 1; k < nums.length; k++){
            f = f + sum - (nums.length * nums[nums.length - k]);
            max = Math.max(f, max);
        }

        return max;
    }
}