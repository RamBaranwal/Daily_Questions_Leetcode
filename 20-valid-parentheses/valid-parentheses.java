class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty()){
                    char lastOne = stack.pop();
                    if((ch == ')' && lastOne != '(') || (ch == '}' && lastOne != '{') || (ch == ']' && lastOne != '[')){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}