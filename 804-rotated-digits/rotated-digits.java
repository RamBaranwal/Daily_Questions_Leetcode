class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(isGoodDigit(i)){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
    private boolean isGoodDigit(int n){
        String s = String.valueOf(n);
        if(s.contains("3") || s.contains("4") || s.contains("7")) {
            return false;
        }
        if(s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
            return true;
        }
        return false;
    }
}