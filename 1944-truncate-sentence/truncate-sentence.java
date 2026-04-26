class Solution {
    public String truncateSentence(String s, int k) {
        String[] world = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
           sb.append(world[i]);
           if(i<k-1) sb.append(" ");
        }
        return sb.toString();
    }
}