class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(res, board, 0);
        return res;
    }
    private void helper(List<List<String>> res, boolean[][] board, int row){
        // checking it that row == length then prnit the matrix
        if(row == board.length){
            List<String> arr = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                String s = "";
                for(int j = 0; j < board.length; j++){
                    if(board[i][j]){
                        s += "Q";
                    }
                    else{
                        s += ".";
                    }
                }
                arr.add(s);
            }
            res.add(arr);
            return;
        }

        // find is safe where we place the queen
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                helper(res, board, row + 1);
                board[row][col] = false;
            }
        }
    }
    private boolean isSafe(boolean[][] board, int row, int col){
        // upward check
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // for daigonally left
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        // diagonally rigth
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }

        // other condition it is true;
        return true;
    }

}