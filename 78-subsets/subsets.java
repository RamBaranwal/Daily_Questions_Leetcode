class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), outer);
        return outer;
    }
    private void subset(int[] nums, int index, List<Integer> current, List<List<Integer>> outer){
        if(index == nums.length){
            outer.add(new ArrayList<>(current));
            return;
        }

        // excluding
        subset(nums, index + 1, current, outer);

        // including
        int element = nums[index];
        current.add(element);

        subset(nums, index + 1, current, outer);

        // backtracking hhelps to make the call current as it is as previous it is called
        current.remove(current.size() - 1);
    }
}