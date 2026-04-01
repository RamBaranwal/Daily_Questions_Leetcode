class Solution {
    public boolean checkValidString(String s) {
        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return false;
        int left = 0;
        int right = 0;
        int center = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == '*') center++;
            else right++;
        }
        if(left == right) return true;
        else{
            if(left > right){
                if(left == right + center) return true;
                return false;
            }
            else{
                if(right == left + center) return true;
                return false;
            }
        }
    }
}