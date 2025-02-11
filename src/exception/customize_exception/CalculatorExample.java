package exception.customize_exception;

import java.util.Scanner;

public class CalculatorExample {
    private void calculate(int x, int y) throws CalculatorException {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.out.println(e);
            throw new CalculatorException("Bị lỗi rồi nè, lỗi này nè: ", e.getMessage());
        }
    }

    public static void main(String[] args) throws CalculatorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = scanner.nextInt();
        System.out.println("Hãy nhập y: ");
        int y = scanner.nextInt();

        CalculatorExample calc = new CalculatorExample();
        calc.calculate(x, y);
    }
}
