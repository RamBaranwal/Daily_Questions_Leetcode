class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // this is done like the find the frequncy till the array from a and b
        int[] fre = new int[A.length + 1];
        int common = 0;
        int[] ans = new int[A.length];
        for(int i = 0; i < A.length; i++){
            fre[A[i]]++;
            if(fre[A[i]] == 2){
                common++;
            }

            fre[B[i]]++;
            if(fre[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }
}