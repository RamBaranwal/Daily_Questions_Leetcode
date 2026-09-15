class Solution {
    public String largestPalindromic(String num) {
        int[] fre = new int[10];
        for(char ch : num.toCharArray()){
            fre[ch - '0']++;
        }

        StringBuilder left = new StringBuilder();

        // for left
        for(int i = 9; i >= 0; i--){
            int count = fre[i] / 2;
            while(count > 0){
                left.append(i);
                count--;
            }
        }
        // for center
        int center = -1;
        for(int i = 9; i >= 0; i--){
            if(fre[i] % 2 != 0){
                center = i;
                break;
            }
        }

        if(left.length() > 0 && left.charAt(0) == '0'){
            if(center == -1 || center == 0){
                return "0";
            }
            return String.valueOf(center);
        }

        StringBuilder res = new StringBuilder();
        res.append(left);
        if(center != -1){
            res.append(center);
        }

        res.append(new StringBuilder(left).reverse());
        return res.toString();
    }
}