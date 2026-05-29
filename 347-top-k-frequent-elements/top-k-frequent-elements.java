class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < k; i++){
            int maxEle = 0;
            int maxFre = 0;
            for(int key : map.keySet()){
                if(map.get(key) > maxFre){
                    maxFre = map.get(key);    // this is value
                    maxEle = key;             // this is key
                }
            }
            res.add(maxEle);
            map.remove(maxEle);               // removing the element
            // map.put(maxEle, 0)             // updating the element
        }

        int[] ans = new int[k];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}