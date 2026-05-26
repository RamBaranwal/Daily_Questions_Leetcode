class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freUpp = new int[26];
        int[] freLow = new int[26];

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                freLow[word.charAt(i) - 'a']++;
            }
            else{
                freUpp[word.charAt(i) - 'A']++;
            }
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(freLow[i] >= 1 && freUpp[i] >= 1){
                count++;
            }
        }
        return count;
    }
}