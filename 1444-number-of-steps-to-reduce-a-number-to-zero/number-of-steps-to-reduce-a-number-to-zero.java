class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }
    private int helper(int num, int count){
        if(num <= 0){
            return count;
        }
        int isEven = num % 2;
        if(isEven == 0){
            return helper(num / 2, count + 1);
        }
        return helper(num - 1, count + 1);
    }
}