class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            res += (i + 1) * (26 - (ch - 'a'));
        }
        return res;
    }
}