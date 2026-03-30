class Solution {
    public boolean checkStrings(String s1, String s2) {
		int[][] fre = new int[2][26];
        for(int i = 0; i < s1.length(); i++){
            fre[i % 2][s1.charAt(i) - 'a']++;
            fre[i % 2][s2.charAt(i) - 'a']--;
        }
        System.out.println(Arrays.deepToString(fre));
        for(int i = 0; i < 26; i++){
            if(fre[0][i] != 0 || fre[1][i] != 0){
                return false;
            }
        }
        return true;
	}
}