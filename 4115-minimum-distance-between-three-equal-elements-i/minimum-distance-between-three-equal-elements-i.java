class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(ArrayList<Integer> list : map.values()){
            if(list.size() >= 3){
                for(int i = 0; i <= list.size() - 3; i++){
                    int first = list.get(i);
                    int second = list.get(i + 1);
                    int last = list.get(i + 2);

                    int dis = Math.abs(first - last) + Math.abs(first - second) + Math.abs(second - last);
                    ans = Math.min(ans, dis);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}