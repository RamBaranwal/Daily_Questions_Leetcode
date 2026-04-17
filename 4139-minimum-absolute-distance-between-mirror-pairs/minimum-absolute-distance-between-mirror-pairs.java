class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++){
            if(res.containsKey(nums[j])){
                min = Math.min(min, j - res.get(nums[j]));
            }
            int rev = reverse(nums[j]);
            res.put(rev, j);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int reverse(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int digit = 0;
        while(n != 0){
            int rem = n % 10;
            digit = 10 * digit + rem;
            n = n / 10;
        }
        return digit;
    }
}