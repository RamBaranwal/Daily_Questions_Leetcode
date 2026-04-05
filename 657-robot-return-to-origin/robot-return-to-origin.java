class Solution {
    public boolean judgeCircle(String moves) {
        int[] fre = new int[26];
        for(char ch : moves.toCharArray()){
            fre[ch - 'A']++;
        }
        if(fre['L' - 'A'] == fre['R' - 'A'] && fre['D' - 'A'] == fre['U' - 'A']) return true;
        return false;
    }
}