package concepts.streamApi;

public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main (String... args){
        Calculator calculator = new Calculator();
        IntegerMath addition = (a, b) -> a + b ;
        IntegerMath subtraction = (a, b) -> a - b ;
        System.out.println(String.format("addition: %d", calculator.operateBinary(2,3, addition)));

        System.out.println(String.format("substraction: %d", calculator.operateBinary(2,3, subtraction)));


    }
}
