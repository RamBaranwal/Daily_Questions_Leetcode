class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = merge(nums1, nums2);
        int len = mergeArray.length;
        // System.out.println(Arrays.toString(mergeArray));
        if(len % 2 != 0){
            return (double)mergeArray[len / 2];
        }
        else{
            return (double)(mergeArray[len / 2] + mergeArray[(len - 1) / 2]) / 2.0;
        }
    }
    private int[] merge(int[] nums1, int[] nums2){
        int[] arr = new int[nums1.length + nums2.length];
        int k = 0;
        int l1 = 0;
        int l2 = 0;
        while(l1 < nums1.length && l2 < nums2.length){
            if(nums1[l1] > nums2[l2]){
                arr[k] = nums2[l2];
                l2++;
                k++;
            }
            else{
                arr[k] = nums1[l1];
                l1++;
                k++;
            }
        }
        while(l1 < nums1.length){
            arr[k] = nums1[l1];
            l1++;
            k++;
        }
        while(l2 < nums2.length){
            arr[k] = nums2[l2];
            l2++;
            k++;
        }
        return arr;
    }
}