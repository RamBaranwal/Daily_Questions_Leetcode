class Solution {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                res.push(ch);
            }
            else{
                if(res.isEmpty()) return false;
                char top = res.pop();
                if((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        return res.isEmpty();
    }
}