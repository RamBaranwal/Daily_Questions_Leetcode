class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // store the values into data structure form
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int key = i - j;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }

        // now sorting
        for(int keys : map.keySet()){
            Collections.sort(map.get(keys));
        }

        // now assing back the same 
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j  < mat[0].length; j++){
                int key = i - j;
                mat[i][j] = map.get(key).remove(0); // assing value to mat[i][j] then removed
            }
        }
        return mat;
    }
}