class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int hei = Math.min(height[left], height[right]);
            int dis = right - left;

            maxWater = Math.max(maxWater, hei * dis);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}