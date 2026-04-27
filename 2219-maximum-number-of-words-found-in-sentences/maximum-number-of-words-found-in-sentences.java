class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        int count = 0;
        for(String s : sentences){
          int length = length(s);
          max = Math.max(length, max);
        }
        return max;
        
    }
    public int length(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                count++;
            }
        }
        return count+1;
    }
}