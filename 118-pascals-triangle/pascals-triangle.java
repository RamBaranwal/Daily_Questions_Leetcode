class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            int num = 1;
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                row.add(num);
                num = num * (i - j) / (j + 1);
            }
            res.add(row);
        }
        return res;
    }
}