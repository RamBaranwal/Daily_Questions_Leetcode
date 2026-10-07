class Solution {
    public int longestMountain(int[] arr) {
        int[] leftLen = new int[arr.length];
        int[] rightLen = new int[arr.length];

        leftLen[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i - 1]){
                leftLen[i] = leftLen[i - 1] + 1;
            }
            else{
                leftLen[i] = 1;
            }
        }

        rightLen[arr.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                rightLen[i] = rightLen[i + 1] + 1;
            }
            else{
                rightLen[i] = 1;
            }
        }

        int maxLen = 0;
        for(int i = 0; i < arr.length; i++){
            if(leftLen[i] > 1 && rightLen[i] > 1){
                int currLen = leftLen[i] + rightLen[i] - 1;
                maxLen = Math.max(currLen, maxLen);
            }
        }

        return maxLen;
    }
}