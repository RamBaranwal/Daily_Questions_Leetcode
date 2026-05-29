class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(nums[i])){
                res.put(nums[i], res.get(nums[i]) + 1);
            }
            else{
                res.put(nums[i], 1);
            }
        }
        for(int key : res.keySet()){
            if(res.get(key) > 1){
                return true;
            }
        }
        return false;
    }
}