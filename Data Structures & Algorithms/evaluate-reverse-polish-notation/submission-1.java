class Solution {
    private boolean isOperator(String element){
        boolean isCharLength = element.length() == 1;
        boolean isOperator = "+-*/".contains(element);

        return isCharLength && isOperator;
    }

    private int calculate(String operator, int operand_1, int operand_2){
        switch(operator){
            case "+":
                return operand_1+operand_2;
            case "-":
                return operand_1-operand_2;
            case "*":
                return operand_1*operand_2;
            case "/":
                return operand_1/operand_2;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String element : tokens){
            if (isOperator(element)){
                
                int openrand_2 = stack.pop();
                int openrand_1 = stack.pop();

                int result = calculate(
                    element,
                    openrand_1,
                    openrand_2
                );

                stack.push(result);
            } else {
                stack.push(
                    Integer.parseInt(element)
                );
            }
        }

        return stack.pop();
    }
}

