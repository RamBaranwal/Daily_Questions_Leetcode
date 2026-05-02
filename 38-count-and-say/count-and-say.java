class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = countAndSay(n - 1);

        String ans = "";

        int i = 0; 
        int j = 0;
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            else{
                int dif = j - i;
                ans = ans + dif;
                ans = ans + s.charAt(i);
                i = j;
            }
        }
        int dif = j - i;
        ans = ans + dif;
        ans = ans + s.charAt(i);
        return ans;
    }
}