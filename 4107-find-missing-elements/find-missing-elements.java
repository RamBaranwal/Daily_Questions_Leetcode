class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1] + 1){
                int left = nums[i - 1] + 1;
                int right = nums[i];
                while(left < right){
                    list.add(left);
                    left++;
                }
            }
        }
        return list;
    }
}