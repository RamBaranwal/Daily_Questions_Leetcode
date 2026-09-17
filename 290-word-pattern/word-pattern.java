class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch1 = pattern.charAt(i);
            String str1 = str[i];
            if(map1.containsKey(ch1)){
                if(!map1.get(ch1).equals(str1)){
                    return false;
                }
            }
            else{
                map1.put(ch1, str1);
            }

            if(map2.containsKey(str1)){
                if(!map2.get(str1).equals(ch1)){
                    return false;
                }
            }
            else{
                map2.put(str1, ch1);
            }
        }
        return true;
    }
}