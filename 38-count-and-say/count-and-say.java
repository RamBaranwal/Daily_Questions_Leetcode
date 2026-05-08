class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        
        String prev = countAndSay(n - 1);

        String res = "";

        int i = 0;
        int lastI = 0;
        int lastJ = 0;
        for(int j = 0; j < prev.length(); j++){
            if(prev.charAt(i) != prev.charAt(j)){
                int diff = j - i;
                res = res + diff;
                res = res + prev.charAt(i);
                i = j;
            }
            lastI = i;
            lastJ = j;
        }
        int diff = lastJ - lastI + 1;
        res = res + diff;
        res = res + prev.charAt(lastI);
        return res;
    }
}