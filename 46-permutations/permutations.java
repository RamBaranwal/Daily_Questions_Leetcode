class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] used){
        if(nums.length == current.size()){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            current.add(nums[i]);
            used[i] = true;
            helper(res, current, nums, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}