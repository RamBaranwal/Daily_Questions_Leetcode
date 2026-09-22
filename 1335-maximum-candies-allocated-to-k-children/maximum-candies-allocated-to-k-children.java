class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        long sum = 0;
        for(int i : candies){
            sum += i;
            max = Math.max(i, max);
        }
        if(sum < k){
            return 0;
        }
        int ans = 0;
        int start = 1;
        int end = max;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int piles = 0;
            long count = 0;
            for(int i = 0; i < candies.length; i++){
                count += (candies[i] / mid);
            }
            if(count >= k){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
}