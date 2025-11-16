class Solution {
    public int numSub(String s) {
        long count = 0, curr = 0;
        long mod = 1_000_000_007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                curr++;           // extend current streak of 1
                count = (count + curr) % mod;
            } else {
                curr = 0;         // streak breaks
            }
        }
        return (int) count;
    }
}