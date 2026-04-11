class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, target, 0, list);
        return list;
    }
    private List<Integer> helper(int nums[], int target, int index, List<Integer> list){
        if(nums.length == index){
            return list;
        }
        if(nums[index] == target){
            list.add(index);
        }
        return helper(nums, target, index + 1, list);
    }
}