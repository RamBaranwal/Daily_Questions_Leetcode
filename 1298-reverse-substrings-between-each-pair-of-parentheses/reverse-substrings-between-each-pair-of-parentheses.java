class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> res = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                StringBuilder sb = new StringBuilder();
                while(res.peek() != '('){
                    sb.append(res.pop());
                }
                res.pop();
                for(char c : sb.toString().toCharArray()){
                    res.push(c);
                }
            }
            else{
                res.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!res.isEmpty()){
            ans.append(res.pop());
        }
        return ans.reverse().toString();
    }
}