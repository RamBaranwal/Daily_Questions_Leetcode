class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] coins = new int[3];
        for(int i = 0; i < bills.length; i++){
            int res = bills[i] / 5 - 1;
            if(res == 0){
                coins[0]++;
            }

            if(res == 1){
                if(coins[0] >= 1){
                    coins[0]--;
                    coins[1]++;
                }
                else{
                    break;
                }
            }

            if(res == 3){
                if(coins[0] >= 1 && coins[1] >= 1){
                    coins[0]--;
                    coins[1]--;
                    coins[2]++;
                }
                else if(coins[0] >= 3){
                    coins[0] -= 3;
                    coins[2]++;
                }
                else{
                    break;
                }
            }
        }
        int result = coins[0] * 5 + coins[1] * 10 + coins[2] * 20;
        int actualResult = bills.length * 5;
        System.out.println(result);
        System.out.println(actualResult);

        return result == actualResult; 
    }
}