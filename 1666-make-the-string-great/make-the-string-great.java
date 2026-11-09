class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() == 0){
            return "";
        }
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty() && Math.abs((int)s.charAt(i) - (int)stack.peek()) == 32){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder br = new StringBuilder();
        while(!stack.isEmpty()){
            br.append(stack.pop());
        }
        return br.reverse().toString();
    }
}