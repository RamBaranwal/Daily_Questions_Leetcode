class Solution {
    public long minimumSteps(String s) {
        int zeroPos = 0;
        char[] ch = s.toCharArray();
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(ch[i] == '0'){
                ans += i - zeroPos;
                zeroPos++;
            }
        }
        return ans;
    }
}