class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        
        // store value into the set 
        for(int num : arr1){
            String s = Integer.toString(num);
            String prefix = "";
            for(int i = 0; i < s.length(); i++){
                prefix += s.charAt(i);
                set.add(prefix);
            }
        }

        // checking the arr2 each element
        for(int num : arr2){
            String prefix = "";
            String s = Integer.toString(num);
            for(int i = 0; i < s.length(); i++){
                prefix += s.charAt(i);
                if(set.contains(prefix)){
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }
        return maxLen;
    }
}