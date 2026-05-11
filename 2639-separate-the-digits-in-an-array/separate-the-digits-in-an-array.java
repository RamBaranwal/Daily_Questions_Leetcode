class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            String currDigit = Integer.toString(nums[i]);
            int j = 0;
            while(j < currDigit.length()){
                res.add((int)(currDigit.charAt(j) - '0'));
                j++;
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}