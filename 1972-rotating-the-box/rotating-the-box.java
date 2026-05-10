class Solution {
    private void swap(char[][] boxGrid, int k, int i, int j){
        char temp = boxGrid[k][i];
        boxGrid[k][i] = boxGrid[k][j];
        boxGrid[k][j] = temp;
    }
    private char[][] transpose(char[][] boxGrid){
        int cols = boxGrid[0].length;
        int rows = boxGrid.length;
        char[][] rotated = new char[cols][rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                rotated[j][rows - 1 - i] = boxGrid[i][j];
            }
        }
        return rotated;
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
        for(int k = 0; k < boxGrid.length; k++){
            int empty = boxGrid[0].length - 1;
            for(int j = boxGrid[0].length - 1; j >= 0; j--){

                if(boxGrid[k][j] == '*'){
                    empty = j - 1;
                }

                else if(boxGrid[k][j] == '#'){

                    boxGrid[k][j] = '.';
                    boxGrid[k][empty] = '#';

                    empty--;
                }
            }
        }
        // rotate array 90 degrees
        char[][] transpose = transpose(boxGrid);
        return transpose;
    }
}