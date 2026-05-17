class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> current, int target, int[] candidates, int index){
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || index == candidates.length){
            return;
        }

        current.add(candidates[index]);
        // take it 
        helper(res, current, target - candidates[index], candidates, index);
        // remove it so it will look same to not pick the number
        current.remove(current.size() - 1);

        // skip it
        helper(res, current, target, candidates, index + 1);
    }
}