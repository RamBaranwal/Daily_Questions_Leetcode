class Solution {
    public boolean isValid(String s) {
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty()){
                    char top = stack.pop();
                    if(ch == ')' && top != '(' ||
                        ch == '}' && top != '{' ||
                        ch == ']' && top != '['
                    ){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}