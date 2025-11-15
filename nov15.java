/*
3234. Count the Number of Substrings With Dominant Ones
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a binary string s.

Return the number of substrings with dominant ones.

A string has dominant ones if the number of ones in the string is greater than or equal to the square of the number of zeros in the string.

 

Example 1:

Input: s = "00011"

Output: 5

Explanation:

The substrings with dominant ones are shown in the table below.

i	j	s[i..j]	Number of Zeros	Number of Ones
3	3	1	0	1
4	4	1	0	1
2	3	01	1	1
3	4	11	0	2
2	4	011	1	2
Example 2:

Input: s = "101101"

Output: 16

Explanation:

The substrings with non-dominant ones are shown in the table below.

Since there are 21 substrings total and 5 of them have non-dominant ones, it follows that there are 16 substrings with dominant ones.

i	j	s[i..j]	Number of Zeros	Number of Ones
1	1	0	1	0
4	4	0	1	0
1	4	0110	2	2
0	4	10110	2	3
1	5	01101	2	3
 

Constraints:

1 <= s.length <= 4 * 104
s consists only of characters '0' and '1'.
*/
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        long total = 1L * n * (n + 1) / 2;

        long allOnesSubs = 0;
        long run = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') run++;
            else {
                if (run > 0) allOnesSubs += run * (run + 1) / 2;
                run = 0;
            }
        }
        if (run > 0) allOnesSubs += run * (run + 1) / 2;

        java.util.List<Integer> z = new java.util.ArrayList<>();
        z.add(0);
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0') z.add(i + 1);

        int m = z.size() - 1;
        z.add(n + 1);

        // FIX #1: cast before returning
        if (m == 0) return (int) total;

        int maxK = (int) Math.sqrt(n);
        long nonDom = 0;
        long sumExactSmallK = 0;

        for (int k = 1; k <= maxK; k++) {
            long T = 1L * k * k + k - 1;

            for (int i = 1; i + k - 1 <= m; i++) {
                int L1 = z.get(i - 1) + 1;
                int R1 = z.get(i);
                int L2 = z.get(i + k - 1);
                int R2 = z.get(i + k) - 1;

                long exactK = 1L * (z.get(i) - z.get(i - 1)) *
                              (z.get(i + k) - z.get(i + k - 1));
                sumExactSmallK += exactK;

                for (int a = L1; a <= R1; a++) {
                    long upperB = Math.min(R2, (long) a + T - 1);
                    if (upperB >= L2) nonDom += (upperB - L2 + 1);
                }
            }
        }

        long substrWithZero = total - allOnesSubs;

        long remaining = substrWithZero - sumExactSmallK;
        if (remaining > 0) nonDom += remaining;

        long ans = total - nonDom;

        // FIX #2: final answer fits in int → cast
        return (int) ans;
    }
}