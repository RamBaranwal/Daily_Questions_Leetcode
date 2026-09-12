class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];
        boolean[] number = new boolean[1000];
        int count = 0;

        for(int i = 0; i < digits.length; i++){
            if(digits[i] == 0){
                continue;
            }
            used[i] = true;

            for(int j = 0; j < digits.length; j++){
                if(used[j]){
                    continue;
                }
                used[j] = true;
                
                for(int k = 0; k < digits.length; k++){
                    if(used[k]){
                        continue;
                    }

                    if(digits[k] % 2 != 0){
                        continue;
                    }

                    int num = digits[i] * 100 +
                            digits[j] * 10 +
                            digits[k];
                    // System.out.println(num);
                    if(!number[num]){
                        number[num] = true;
                        count++;
                        // System.out.println(count);
                    }
                }

                used[j] = false;
            }

            used[i] = false;
        }
        return count;
    }
}