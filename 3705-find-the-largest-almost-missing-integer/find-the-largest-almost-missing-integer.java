class Solution {
    public int largestInteger(int[] nums, int k) {
        if(k == 1){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int max = -1;
            for(Integer key : map.keySet()){
                if(map.get(key) == 1){
                    max = Math.max(max, key);
                }
            }
            return max;
        }

        if(nums.length == k){
            int max = 0;
            for(int num : nums){
                max = Math.max(max, num);
            }
            return max;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(map.get(nums[0]) > 1 && map.get(nums[nums.length - 1]) > 1){
            return -1;
        }
        else if(map.get(nums[0]) > 1 && map.get(nums[nums.length - 1]) == 1){
            return nums[nums.length - 1];
        }
        else if(map.get(nums[0]) == 1 && map.get(nums[nums.length - 1]) > 1){
            return nums[0];
        }
        else{
            return Math.max(nums[0], nums[nums.length - 1]);
        }
    }
}