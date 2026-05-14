class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    for(int fill = 1; fill <= 9; fill++){
                        if(isSafe(fill, board, i, j)){
                            board[i][j] = (char)(fill + '0');
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int num, char[][] board, int row, int col){
        char ch = (char)(num + '0');
        // for row
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == ch){
                return false;
            }
        }

        // for col
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == ch){
                return false;
            }
        }

        // for box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i = startRow; i < startRow + 3; i++){
            for(int j = startCol; j < startCol + 3; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
}