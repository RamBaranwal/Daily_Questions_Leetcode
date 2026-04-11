class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            res.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minCount = Integer.MAX_VALUE;

        for(ArrayList<Integer> list : res.values()){
            if(list.size() >= 3){
                for(int i = 0; i <= list.size() - 3; i++){
                    int dis = Math.abs(list.get(i) - list.get(i + 1)) + Math.abs(list.get(i + 1) - list.get(i + 2)) + Math.abs(list.get(i + 2) - list.get(i));

                    minCount = Math.min(dis, minCount);
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}