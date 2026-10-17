class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        for(int num : nums){
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : fre.entrySet()){
            if(entry.getValue() == 2){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}