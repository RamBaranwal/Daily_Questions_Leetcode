class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), outer);
        return outer;
    }
    private List<List<Integer>> helper(int[] nums, int index, List<Integer> current, List<List<Integer>> outer){
        outer.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            helper(nums, i + 1, current, outer);
            current.remove(current.size() - 1);
        }
        return outer;
    }
}