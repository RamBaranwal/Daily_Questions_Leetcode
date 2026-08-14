class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> fre = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            fre.put(s.charAt(i), fre.getOrDefault(s.charAt(i), 0) + 1);
            while(fre.get(s.charAt(i)) > 2){
                fre.put(s.charAt(left), fre.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}