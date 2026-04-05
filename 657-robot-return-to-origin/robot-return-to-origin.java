class Solution {
    public boolean judgeCircle(String moves) {
        int upDownShift = 0;
        int leftRightShift = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'U'){
                upDownShift++;
            }
            else if(ch == 'D'){
                upDownShift--;
            }
            else if(ch == 'L'){
                leftRightShift++;
            }
            else{
                leftRightShift--;
            }
        }
        if(upDownShift == 0 && leftRightShift == 0){
            return true;
        }
        return false;
    }
}