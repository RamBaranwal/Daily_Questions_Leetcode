class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            int sum = 0;
            for(int i = 0; i < word.length(); i++){
                sum += weights[word.charAt(i) - 'a'];
            }
            sum = sum % 26;
            char ch = (char)('a' + 26 - sum - 1);
            sb.append(ch);
       }
       return sb.toString();
    }
}