class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            HashMap<Integer, Integer> fre = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < 1 || matrix[i][j] > n){
                    return false;
                }
                fre.put(matrix[i][j], fre.getOrDefault(matrix[i][j], 0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry : fre.entrySet()){
                if(entry.getValue() > 1){
                    return false;
                }
            }
        }
        for(int j = 0; j < n; j++){
            HashMap<Integer, Integer> fre = new HashMap<>();
            for(int i = 0; i < n; i++){
                if(matrix[i][j] < 1 || matrix[i][j] > n){
                    return false;
                }
                fre.put(matrix[i][j], fre.getOrDefault(matrix[i][j], 0) + 1);
            }
            for(Map.Entry<Integer,Integer> entry : fre.entrySet()){
                if(entry.getValue() > 1){
                    return false;
                }
            }
        }
        return true;
    }
}