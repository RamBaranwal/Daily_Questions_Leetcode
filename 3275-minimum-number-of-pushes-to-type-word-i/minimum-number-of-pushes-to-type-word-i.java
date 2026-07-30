class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> set = new HashMap<>();

        int count = 1; 
        int value = 1; 
        for(int i = 0; i < word.length(); i++){
            if(count > 8){
                count = 1;
                value++;
                set.put(word.charAt(i), value);
                count++;
            }
            else{
                set.put(word.charAt(i), value);
                count++;
            }
        }
        int sum = 0;
        for(Character ch : set.keySet()){
            sum += set.get(ch);
        }
        System.out.println(set);
        return sum;
    }
}