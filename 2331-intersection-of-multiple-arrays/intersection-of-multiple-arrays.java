class Solution {
    public List<Integer> intersection(int[][] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> fre = new HashMap<>();
        for(int[] num : nums){
            for(int n : num){
                fre.put(n, fre.getOrDefault(n, 0) + 1);
            }
        }
        // for(Map.Entry<Integer, Integer> entry : fre.entrySet()){
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }
        List<Integer> res = new ArrayList<>();
        for(Integer n : fre.keySet()){
            if(fre.get(n) == len){
                res.add(n);
            }
        }
        Collections.sort(res);
        return res;
    }
}