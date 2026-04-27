class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String str : sentences){
            String[] eachstr = str.split(" ");
            int n = eachstr.length;
            max = Math.max(max, n);
        }
        return max;
    }
}