class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> tree = new HashMap<>();
        for(char ch : s.toCharArray()){
            tree.put(ch, tree.getOrDefault(ch, 0) + 1);
        }
        String res = "";

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(tree.entrySet());
        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        for(int i = 0; i < list.size(); i++){
            int j = list.get(i).getValue();
            while(j > 0){
                res += list.get(i).getKey();
                j--;
            }
        }
        return res;
    }
}