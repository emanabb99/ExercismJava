class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation){
        int result = 0;
        switch (operation) {
            case "+" : result = operand1 + operand2;
            break;
            case "*" : result = operand1 * operand2;
            break;
            case "/" :
                if (operand2 == 0) {
                    throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
                }
                result = operand1 / operand2;
                break;
            case "" : throw new IllegalArgumentException("Operation cannot be empty");
            case null : throw new IllegalArgumentException("Operation cannot be null");
            default: throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return String.valueOf(operand1) + " " + operation + " " + String.valueOf(operand2) + " = " + result;
    }
}
