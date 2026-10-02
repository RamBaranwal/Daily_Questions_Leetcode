class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        return helper("", 0, 0, n);
    }
    private ArrayList<String> helper(String p, int l, int r, int n){
        ArrayList<String> res = new ArrayList<>();
        if(r == n){
            res.add(p);
            return res;
        }

        if(l < n){
            res.addAll(helper(p + "(", l + 1, r, n));
        }

        if(r < l){
            res.addAll(helper(p + ")", l, r + 1, n));
        }

        return res;
    }
}