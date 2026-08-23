class Solution {
    public boolean checkDivisibility(int n) {
        int sum = Sum(n);
        int mul = Mul(n);
        return n % (sum + mul) == 0; 
    }
    private int Sum(int n){
        int sum = 0;
        while(n > 0){
            int temp = n % 10;
            sum += temp;
            n /= 10;
        }
        return sum;
    }
    private int Mul(int n){
        int mul = 1;
        while(n > 0){
            int temp = n % 10;
            mul *= temp;
            n /= 10;
        }
        return mul;
    }
}