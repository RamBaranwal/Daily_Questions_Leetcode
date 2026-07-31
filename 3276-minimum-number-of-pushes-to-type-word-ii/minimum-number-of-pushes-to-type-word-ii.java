class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> fre = new HashMap<>();
        for(char ch : word.toCharArray()){
            fre.put(ch, fre.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(fre.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int count = 0;
        int value = 1;
        int sum = 0;
        for(Map.Entry<Character, Integer> entry : list){
            char ch = entry.getKey();
            if(count < 8){
                int freq = entry.getValue();
                // System.out.println(freq * value + "...");
                sum += freq * value;
                // System.out.println(sum + "....");
                count++;
            }
            else{
                value++;
                count = 0;
                int freq = entry.getValue();
                // System.out.println(freq * value + ".");
                sum += freq * value;
                // System.out.println(sum + "..");
                count++;
            }
        }
        // System.out.println(list);

        return sum;
    }
}