class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char ch : s1.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        int k = s1.length();
        for(int i = 0; i < k; i++){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if(map1.equals(map2)){
            return true;
        }
        for(int i = k; i < s2.length(); i++){
            char leftCh = s2.charAt(i - k);
            map2.put(leftCh, map2.get(leftCh) - 1);

            if(map2.get(leftCh) == 0){
                map2.remove(leftCh);
            }

            char rightCh = s2.charAt(i);
            map2.put(rightCh, map2.getOrDefault(rightCh, 0) + 1);

            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
