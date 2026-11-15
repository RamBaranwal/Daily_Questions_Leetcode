class Solution {
    int MOD = 1_000_000_007;
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        long count = 0;
        for(int num : arr){
            if(num % 2 == 0){
                even = even + 1;
            }
            else{
                int temp = even;
                even = odd;
                odd = temp + 1;
            }
            count = (count + odd) % MOD;
        }
        return (int)count;
    }
}