class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int max = piles[0];
        for(int i = 0; i < piles.length; i++){
            sum += piles[i];
            max = Math.max(max, piles[i]);
        }
        if(sum <= h){
            return 1;
        }
        int start = 1;
        int end = max;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                if(piles[i] % mid != 0){
                    hours += (piles[i] / mid) + 1;
                }
                else{
                    hours += (piles[i] / mid);
                }
            }
            if(hours <= h){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}