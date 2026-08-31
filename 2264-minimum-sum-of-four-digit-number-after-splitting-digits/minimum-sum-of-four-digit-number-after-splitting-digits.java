class Solution {
    public int minimumSum(int num) {
        int digit = 0;
        int[] fre = new int[10];
        while(num != 0){
            int rem = num % 10;
            fre[rem]++;
            num /= 10;
        }
        // System.out.println(Arrays.toString(fre));
        for(int i = 0; i < 10; i++){
            while(fre[i] > 0){
                digit = digit * 10 + i;
                fre[i]--;
            }
        }
        // System.out.println(digit);
        String str = Integer.toString(digit);
        while(str.length() != 4){
            str = "0" + str;
        }
        System.out.println(str);
        String str1 = "" + str.charAt(0) + str.charAt(2);
        String str2 = "" + str.charAt(1) + str.charAt(3);
        int new1 = Integer.parseInt(str1);
        int new2 = Integer.parseInt(str2);
        return new1 + new2;
        // return 0;
    }
}