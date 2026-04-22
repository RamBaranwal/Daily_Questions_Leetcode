class Solution {
    public int numberOfMatches(int n) {
        int advance = n;
        int matches = 0;
        while(advance > 1){
            if(advance % 2 != 0){
                matches += (advance - 1) / 2;
                advance = ((advance - 1) / 2) + 1;
            }
            else{
                matches += advance / 2;
                advance = advance / 2;
            }
        }
        return matches;
    }
}