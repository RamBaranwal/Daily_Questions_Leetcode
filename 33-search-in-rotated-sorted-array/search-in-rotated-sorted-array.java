class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    private int binarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end -start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[start] <= arr[mid]){
            if(arr[start] <= target && arr[mid] > target){
                return binarySearch(arr, target, start, mid - 1);
            }
            else{
                return binarySearch(arr, target, mid + 1, end);
            }
        }
        else{
            if(arr[mid] < target && arr[end] >= target){
                return binarySearch(arr, target, mid + 1, end);
            }
            else{
                return binarySearch(arr, target, start, mid - 1);
            }
        }
    }
}