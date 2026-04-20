class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        for(int i = 0; i < colors.length; i++){
        int j = colors.length - 1;
            while(i < j){
                if(colors[i] != colors[j]){
                    max = Math.max(max, Math.abs(j - i));
                    break;
                }
                else{
                    j--;
                }
            }
            j = colors.length - 1;
        }
        return max;
    }
}