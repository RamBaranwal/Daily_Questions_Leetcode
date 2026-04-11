class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, 0);
    }
    private List<Integer> helper(int[] nums, int target, int index){
        List<Integer> res = new ArrayList<>();
        if(nums.length == index){
            return res;
        }
        if(nums[index] == target){
            res.add(index);
        }
        List<Integer> addBelowCalls = helper(nums, target, index + 1);
        res.addAll(addBelowCalls);
        return res;
    }
}