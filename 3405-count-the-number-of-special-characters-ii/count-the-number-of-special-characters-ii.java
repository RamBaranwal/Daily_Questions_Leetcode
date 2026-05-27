class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> low = new HashMap<>();
        HashMap<Character,Integer> upp = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            if(Character.isLowerCase(word.charAt(i))){
                low.put(word.charAt(i), i);
            }
            else{
                if(!upp.containsKey(word.charAt(i))){
                    upp.put(word.charAt(i), i);
                }
            }
        }
        int count = 0;
        for(char ch : upp.keySet()){
            char lowerCase = Character.toLowerCase(ch);

            if(low.containsKey(lowerCase)){
                int uppCharIndex = upp.get(ch);
                int lowCharIndex = low.get(lowerCase);
                if(uppCharIndex > lowCharIndex){
                    count++;
                }
            }
        }
        return count;
    }
}