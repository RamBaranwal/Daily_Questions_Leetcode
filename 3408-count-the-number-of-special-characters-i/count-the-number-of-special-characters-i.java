class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] freUpp = new boolean[26];
        boolean[] freLow = new boolean[26];

        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                freLow[ch - 'a'] = true;
            }
            else{
                freUpp[ch - 'A'] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(freLow[i] && freUpp[i]){
                count++;
            }
        }

        return count;
    }
}