class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        int diff = xor & -xor;
        ArrayList<Integer> groupA = new ArrayList<>();
        ArrayList<Integer> groupB = new ArrayList<>();
        for(int i : nums){
            if((i & diff) != 0){
                groupA.add(i);
            }
            else{
                groupB.add(i);
            }
        }
        int[] ans = new int[2];
        ans[0] = 0;
        for(int i : groupA){
            ans[0] ^= i;
        }
        for(int i : groupB){
            ans[1] ^= i;
        }
        return ans;
    }
}