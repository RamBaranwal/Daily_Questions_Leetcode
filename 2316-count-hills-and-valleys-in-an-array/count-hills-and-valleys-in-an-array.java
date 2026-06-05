class Solution {
    public int countHillValley(int[] nums) {
        ArrayList<Integer> moun = new ArrayList<>();
        moun.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                moun.add(nums[i]);
            }
        }

        int count = 0;
        for(int i = 1; i < moun.size() - 1; i++){
            if(moun.get(i) > moun.get(i - 1) && moun.get(i) > moun.get(i + 1)){
                count++;
            }
            if(moun.get(i) < moun.get(i - 1) && moun.get(i) < moun.get(i + 1)){
                count++;
            }
        }
        return count;
    }
}