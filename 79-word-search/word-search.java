class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int row, int col, int index){
        if(word.length() == index){
            return true;
        }
        
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0){
            return false;
        }
        
        if(board[row][col] != word.charAt(index)){
            return false;
        }


        char temp = board[row][col];
        board[row][col] = '#';

        boolean down = helper(board, word, row + 1, col, index + 1);
        boolean right = helper(board, word, row, col + 1, index + 1);
        boolean up = helper(board, word, row - 1, col, index + 1);
        boolean left = helper(board, word, row, col - 1, index + 1);

        // backtracking
        board[row][col] = temp;
        return down || right || up || left; 
    }
}