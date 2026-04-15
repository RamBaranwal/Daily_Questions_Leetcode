class Solution {
    public int closestTarget(String[] arr, String target, int startIndex) {
        // see backward direction 
        int n = arr.length;
        int k = startIndex;
        int backCount = 0;
        for(int i = 0; i < n; i++){
            if(k < 0){
                k = n - 1;
            }
            if(!arr[k--].equals(target)){
                backCount++;
            }
            else{
                break;
            }
        }

        // see forward direction
        int frontCount = 0;
        int l = startIndex;
        for(int i = 0; i < n; i++){
            if(l > n - 1){
                l = 0;
            }
            if(!arr[l++].equals(target)){
                frontCount++;
            }
            else{
                break;
            }
        }
        return Math.min(frontCount, backCount) == n ? -1 : Math.min(frontCount, backCount);
    }
}