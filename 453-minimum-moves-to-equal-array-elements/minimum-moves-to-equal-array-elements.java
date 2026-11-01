class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
        }

        int totalMoves = 0;
        for(int num : nums){
            totalMoves += (num - min);
        }

        return totalMoves;
    }
}