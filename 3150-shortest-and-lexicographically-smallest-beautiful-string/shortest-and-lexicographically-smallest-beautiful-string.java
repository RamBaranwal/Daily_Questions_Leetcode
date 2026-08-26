class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                index.add(i);
            }
        }
        if(index.size() < k){
            return "";
        }
        String ans = "";

        for(int i = 0; i < index.size() - k + 1; i++){
            String current = s.substring(index.get(i), index.get(i + k - 1) + 1);

            if (ans.equals("") ||
                current.length() < ans.length() ||
                (current.length() == ans.length()
                    && current.compareTo(ans) < 0)) {

                ans = current;
            }
        }

        return ans;
    }
}