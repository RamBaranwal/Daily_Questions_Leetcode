class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : ransomNote.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
        }
        for(char ch : magazine.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
            }
            else{
                map.put(ch, -1);
            }
        }
        for(char key : map.keySet()){
            if(map.get(key) >= 1){
                return false;
            }
        }
        return true;
    }
}