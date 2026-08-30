class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }

        // System.out.println(maxIndex);
        // System.out.println(minIndex);

        int n = nums.length;
        // System.out.println(n);
        if(minIndex > n / 2 && maxIndex < n / 2){
            int nearest = Math.min(n - minIndex, maxIndex + 1);
            int byNearest = nearest + (minIndex - maxIndex);
            int bySplit = maxIndex + 1 + (n - minIndex);
            return Math.min(byNearest, bySplit);
        }

        if(minIndex < n / 2 && maxIndex > n / 2){
            int nearest = Math.min(n - maxIndex, minIndex + 1);
            // System.out.println(nearest);
            int byNearest = nearest + (maxIndex - minIndex);
            // System.out.println(byNearest);
            int bySplit = minIndex + 1 + (n - maxIndex);
            // System.out.println(bySplit);
            return Math.min(byNearest, bySplit);
        }

        if(minIndex >= n / 2 && maxIndex >= n / 2){
            if(maxIndex > minIndex){
                return (n - maxIndex) + (maxIndex - minIndex);
            }
            else{
                return (n - minIndex) + (minIndex - maxIndex);
            }
        }

        if(minIndex <= n / 2 && maxIndex <= n / 2){
            if(maxIndex > minIndex){
                return (minIndex + 1) + (maxIndex - minIndex);
            }
            else{
                return (maxIndex + 1) + (minIndex - maxIndex);
            }
        }
        return 1;
    }
}