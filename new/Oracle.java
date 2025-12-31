Oracle:

(a+b)-C+[D+e]

public boolean validateExpression(String exp){

    Stack<Character> stack = new Stack<>();

    for(char ch : exp.toCharArray()){
        if(ch == '(' || ch == '['){
            stack.push(ch);
        }
        else if(ch == ')' || ch == ']'){
            if(!stack.isEmpty()){
                return false;
            }
            char c = stack.pop();
            if(!isValidPar(c, ch))
                return false;
            if(prev == '(' || isOperator(prev))
        }
        prev = ch;
    }
    return stack.isEmpty();
}


private staic boolean isValidPar(char c, char ch){
    return (c == '(' && ch == ')') || (c == '[' && ch == ']');
}

private static boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

