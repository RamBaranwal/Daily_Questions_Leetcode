class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String st = strs[i];
            char[] fre = st.toCharArray();
            Arrays.sort(fre);
            String newSt = new String(fre);
            if(!map.containsKey(newSt)){
                map.put(newSt, new ArrayList<>());
            }
            map.get(newSt).add(st);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(String st : map.keySet()){
            res.add(map.get(st));
        }

        return res;
    }
}