class Solution {
    public boolean sumGame(String num) {
        int leftSum = 0;
        int rightSum = 0;
        int leftQue = 0;
        int rightQue = 0;
        for(int i = 0; i < num.length() / 2; i++){
            char ch = num.charAt(i);
            if(ch != '?'){
                leftSum += ch - '0';
            }
            else{
                leftQue++;
            }
        }
        for(int i = num.length() / 2; i < num.length(); i++){
            char ch = num.charAt(i);
            if(ch != '?'){
                rightSum += ch - '0';
            }
            else{
                rightQue++;
            }
        }

        if((rightQue + leftQue) % 2 != 0){
            return true;
        }

        int sumDiff = rightSum - leftSum;
        int queDiff = rightQue - leftQue;

        return sumDiff != -9 * (queDiff / 2);
    }
}