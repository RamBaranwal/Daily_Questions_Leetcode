class Solution {
    private String swap(String str, int a, int b){
        StringBuilder sb = new StringBuilder(str);
        char temp = str.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);
        return sb.toString();
    }
    public boolean canBeEqual(String s1, String s2) {
        // check all the possible ways that the string is move 
        if(s1.equals(s2)) return true;
        s1 = swap(s1, 2, 0);
        if(s1.equals(s2)) return true;
        s1 = swap(s1, 3, 1);
        if(s1.equals(s2)) return true;
        s1 = swap(s1, 2, 0);
        if(s1.equals(s2)) return true;
        return false;
    }
}