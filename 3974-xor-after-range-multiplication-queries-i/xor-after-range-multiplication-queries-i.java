class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        int n = nums.length;

        long[] multiplier = new long[n];
        Arrays.fill(multiplier, 1);

        for(int[] que : queries){
            int li = que[0];
            int ri = que[1];
            int ki = que[2];
            int vi = que[3];

            for(int j = li; j <= ri; j += ki){
                multiplier[j] = (int)((multiplier[j] * vi) % MOD);
            }
        }
        int xor = 0;
        for(int i = 0; i < n; i++){
            nums[i] = (int)((nums[i] * multiplier[i]) % MOD);
            xor ^= nums[i];
        }
        return xor;
    }
}