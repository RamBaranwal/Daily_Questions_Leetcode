class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for(int i = 0; i < n; i++){
            int forward = (startIndex + i) % n;
            int backward = (startIndex - i + n) % n;
            if(words[forward].equals(target) || words[backward].equals(target)){
                return i;
            }
        }
        return -1;
    }
}