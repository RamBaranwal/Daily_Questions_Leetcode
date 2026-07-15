class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] fre = new int[26];
        for(int i = 0; i < s1.length(); i++){
            fre[s1.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(fre));
        int len = s1.length();
        for(int i = 0; i < len; i++){
            fre[s2.charAt(i) - 'a']--;
        }
        // System.out.println(Arrays.toString(fre));
        if(isEmpty(fre)){
            return true;
        }
        for(int i = len; i < s2.length(); i++){
            fre[s2.charAt(i - len) - 'a']++;
            fre[s2.charAt(i) - 'a']--;
            System.out.println(Arrays.toString(fre));
            if(isEmpty(fre)){
                return true;
            }
        }
        return false;
    }
    private boolean isEmpty(int[] arr){
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}