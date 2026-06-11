class Solution {
    public String getHint(String secret, String guess) {
        int[] freSec = new int[10];
        int[] freGue = new int[10];

        int bulls = 0;
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                continue;
            }
            freSec[secret.charAt(i) - '0']++;
            freGue[guess.charAt(i) - '0']++;
        }

        int cows = 0;
        for(int i = 0; i < 10; i++){
            cows += Math.min(freSec[i], freGue[i]);
        }

        return bulls + "A" + cows + "B";
    }
}