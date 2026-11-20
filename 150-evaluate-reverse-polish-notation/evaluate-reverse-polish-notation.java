class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") &&
               !tokens[i].equals("-") &&
               !tokens[i].equals("*") &&
               !tokens[i].equals("/"))
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                char ch = tokens[i].charAt(0);

                switch (ch){
                    case '+':
                        ans = a + b;
                        break;

                    case '-':
                        ans = b - a;
                        break;

                    case '*':
                        ans = a * b;
                        break;
                    
                    case '/':
                        ans = b / a;
                        break;
                }
                stack.push(ans);
            }
        }
        return stack.pop();
    }
}