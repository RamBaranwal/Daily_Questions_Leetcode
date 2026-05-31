class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        Arrays.sort(arr);
        long currMass = mass;
        for(int i = 0; i < arr.length; i++){
            if(currMass >= arr[i]){
                currMass += arr[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
}