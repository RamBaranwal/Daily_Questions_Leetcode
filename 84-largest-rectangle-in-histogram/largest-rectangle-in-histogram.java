class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        // for rest
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek();

            int width = right - left - 1;
            int area = width * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}