class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(0, 0, n, "", list);
        return list;
    }
    private void helper(int l, int r, int n, String s, List<String> list){
        if(r == n){
            list.add(s);
            return;
        }
        if(l < n) helper(l + 1, r, n, s + "(", list);
        if(r < l) helper(l, r + 1, n, s + ")", list);
    }
}