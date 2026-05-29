class Solution {
    public int maxFrequencyElements(int[] nums) {
        // doing by hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // this is direct fre count method
        // ===================================================
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // ===================================================
        // this is maually putting
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                map.put(num, 1);
            }
        }
        int maxFre = 0;
        int sum = 0;
        for(int key : map.keySet()){
            if(map.get(key) > maxFre){
                maxFre = map.get(key);
                sum = 0;
            }
            if(map.get(key) == maxFre){
                sum += map.get(key);
            }
        }

        return sum;
    }
}