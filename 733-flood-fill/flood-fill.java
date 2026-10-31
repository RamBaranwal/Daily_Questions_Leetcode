class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color){
            return image;
        }
        filled(image, sr, sc, originalColor, color);
        return image;
    }
    private void filled(int[][] image, int row, int col, int originalColor, int color){
        if(row < 0 || col < 0 || row == image.length || col == image[0].length){
            return;
        }
        if(image[row][col] != originalColor){
            return;
        }

        image[row][col] = color;
        filled(image, row + 1, col, originalColor, color);
        filled(image, row - 1, col, originalColor, color);
        filled(image, row, col + 1, originalColor, color);
        filled(image, row, col - 1, originalColor, color);
    }
}