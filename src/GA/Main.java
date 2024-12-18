package GA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập dung lượng túi
        System.out.print("Nhập sức chứa của túi: ");
        double capacity = scanner.nextDouble();

        Knapsack knapsack = new Knapsack(capacity);

        // Nhập số lượng vật phẩm
        System.out.print("Nhập số lượng vật phẩm: ");
        int numItems = scanner.nextInt();

        // Mảng lưu trọng lượng và giá trị
        double[] weights = new double[numItems];
        double[] values = new double[numItems];

        // Nhập trọng lượng cho từng vật phẩm
        System.out.println("Nhập trọng lượng cho từng vật phẩm");
        for (int i = 0; i < numItems; i++) {
            System.out.printf("Trọng lượng của vật phẩm %d: ", i + 1);
            weights[i] = scanner.nextDouble();
        }

        // Nhập giá trị cho từng vật phẩm
        System.out.println("Nhập giá trị cho từng vật phẩm:");
        for (int i = 0; i < numItems; i++) {
            System.out.printf("Giá trị của vật phẩm %d: ", i + 1);
            values[i] = scanner.nextDouble();
        }

        // Thêm từng vật phẩm vào túi
        for (int i = 0; i < numItems; i++) {
            knapsack.addItem(new Item(values[i], weights[i]));
        }

        // Giải bài toán cái túi
        knapsack.solve();

        // Hiển thị kết quả
        System.out.println("\nDanh sách vật phẩm được chọn:");
        for (Item item : knapsack.getSelectedItems()) {
            System.out.println(item);
        }

        System.out.printf("\nTổng giá trị: %.2f\n", knapsack.getTotalValue());
        System.out.printf("Tổng trọng lượng: %.2f\n", knapsack.getTotalWeight());
    }
}
