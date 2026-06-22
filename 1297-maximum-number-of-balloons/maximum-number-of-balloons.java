class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] fre = new int[26];
        for(char ch : text.toCharArray()){
            fre[ch - 'a']++;
        }
        System.out.println(Arrays.toString(fre));
        // return 0;
        int res = Math.min(fre[0], Math.min(fre[1], Math.min(fre[11] / 2, Math.min(fre[13], fre[14] / 2))));
        return res;
    }
}