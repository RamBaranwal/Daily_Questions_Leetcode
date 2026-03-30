class Solution {
    public boolean checkStrings(String s1, String s2) {
        char[] evenIndElements1;
        if(s1.length() % 2 != 0){
            evenIndElements1 = new char[s1.length() / 2 + 1];
        }
        else{
            evenIndElements1 = new char[s1.length() / 2];
        }
        char[] oddIndElements1 = new char[s1.length() / 2];
        int j = 0;
        for(int i = 0; i < s1.length(); i++){
            if(i % 2 == 0){
                evenIndElements1[j] = s1.charAt(i);
            }
            else{
                oddIndElements1[j] = s1.charAt(i);
                j++;
            }
        }
        char[] evenIndElements2;
        if(s2.length() % 2 != 0){
            evenIndElements2 = new char[s2.length() / 2 + 1];
        }
        else{
            evenIndElements2 = new char[s2.length() / 2];
        }
        char[] oddIndElements2 = new char[s2.length() / 2];
        j = 0;
        for(int i = 0; i < s2.length(); i++){
            if(i % 2 == 0){
                evenIndElements2[j] = s2.charAt(i);
            }
            else{
                oddIndElements2[j] = s2.charAt(i);
                j++;
            }
        }
        Arrays.sort(evenIndElements1);
        Arrays.sort(oddIndElements1);
        Arrays.sort(evenIndElements2);
        Arrays.sort(oddIndElements2);
        if(Arrays.equals(evenIndElements1, evenIndElements2) && Arrays.equals(oddIndElements1, oddIndElements2)){
            return true;
        }
        return false;
    }
}