class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int[] sum = new int[costs.length + 1];
        sum[0] = 0;

        for(int i = 1; i <= costs.length; i ++){
            sum[i] = sum[i - 1] + costs[i - 1];
        }
        System.out.println(Arrays.toString(sum));
        for(int i = 0; i < sum.length; i++){
            if(sum[i] > coins){
                return i - 1;
            }
        }
        return sum.length - 1;
    }
}