class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

        for(int num : nums){
            moves += (max - num);
        }
        return moves;
    }
}