class Solution {
    public String longestPalindrome(String s) {
        // into dp
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        // making single one to be palidromic because a is palindromic to a
        for(int i = 0; i < n; i++){
            maxLen = 1;
            dp[i][i] = true;
        }

        // making 2 common palindrmic 
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // rest of the values
        for(int len = 3; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}