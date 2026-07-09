class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            fast = findSquare(findSquare(fast));
            slow = findSquare(slow);
        }while(fast != slow);
        if(fast == 1){
            return true;
        }
        return false;
    }
    private int findSquare(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }
}