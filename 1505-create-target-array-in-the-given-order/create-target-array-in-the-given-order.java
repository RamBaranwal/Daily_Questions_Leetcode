class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> target = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            target.add(index[i], nums[i]);
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = target.get(i);
        }
        return res;
    }
}