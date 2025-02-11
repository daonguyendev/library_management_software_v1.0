package exception.existing_exception;

import java.util.Scanner;

public class ArrayOutOfBoundMain {

    public static void main(String[] args) {
        ArrayOutOfBoundExample example = new ArrayOutOfBoundExample();
        Integer[] arr = example.createRandomNumbers();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số 1 của một phần tử bất kỳ: ");
        int x = scanner.nextInt();
        System.out.println("\nVui lòng nhập chỉ số 2 của một phần tử bất kỳ: ");
        int z = scanner.nextInt();

//        System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
//        System.out.println("Giá trị của phần tử có chỉ số " + z + " là " + arr[z]);

        try {
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
            int y = x / z;
            System.out.println("Giá trị của phần tử có chỉ số " + y + " là " + arr[y]);

//            if (y < 0) {
//                throw new RuntimeException("Không có chỉ số mảng bé hơn 0, vui lòng nhập lại!");
//            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        } catch (ArithmeticException e) {
            System.err.println("Không thể chia cho số 0");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Chào tạm biệt, hẹn gặp lại!");
        }
    }
}
