class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int digit : digits){
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        int count = 0;
        for(int num = 100; num <= 998; num += 2){
            int a = (num / 100);
            int b = (num / 10) % 10;
            int c = (num % 10);

            HashMap<Integer, Integer> required = new HashMap<>();
            required.put(a, required.getOrDefault(a, 0) + 1);
            required.put(b, required.getOrDefault(b, 0) + 1);
            required.put(c, required.getOrDefault(c, 0) + 1);

            boolean possible = true;

            for(int digit : required.keySet()){
                if(required.get(digit) > map.getOrDefault(digit, 0)){
                    possible = false;
                    break;
                }
            }

            if(possible){
                count++;
            }
        }
        return count;
    }
}