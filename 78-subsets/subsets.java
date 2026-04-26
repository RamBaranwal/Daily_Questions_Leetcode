class Solution {
    public List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        helper(arr, outer);
        return outer;
    }
    private void helper(int[] arr, List<List<Integer>> outer){
        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
    }
}