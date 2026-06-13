class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        HashMap<Integer, Integer> freCount = new HashMap<>();
        for(int value : map.values()){
            if(freCount.containsKey(value)){
                freCount.put(value, freCount.get(value) + 1);
            }
            else{
                freCount.put(value, 1);
            }
        }

        for(int num : nums){
            int fre = map.get(num);
            if(freCount.get(fre) == 1){
                return num;
            }
        }
        return -1;
    }
}