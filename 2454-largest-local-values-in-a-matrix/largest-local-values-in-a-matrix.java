class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid.length - 2];
        int row = 0;
        int col = 0;
        while(row < grid.length - 2){
            while(col < grid.length - 2){
                int max = 0;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        max = Math.max(max, grid[i + row][j + col]);
                    }
                }
                res[row][col] = max;
                col++;
            }
            row++;
            col = 0;
        }
        return res;
    }
}