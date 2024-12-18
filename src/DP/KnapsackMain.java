package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackMain {
    public static void main(String[] args) {
        // Khởi tạo Scanner để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng vật phẩm
        System.out.print("Nhập số lượng vật phẩm: ");
        int n = scanner.nextInt();

        // Nhập sức chứa của túi
        System.out.print("Nhập sức chứa của túi: ");
        int capacity = scanner.nextInt();

        // Khởi tạo mảng trọng lượng và giá trị
        List<Item> items = new ArrayList<>();
        
        // Nhập trọng lượng và giá trị của từng vật phẩm
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập trọng lượng của vật phẩm " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            System.out.print("Nhập giá trị của vật phẩm " + (i + 1) + ": ");
            int value = scanner.nextInt();
            items.add(new Item(weight, value));
        }

        // Khởi tạo túi với sức chứa đã nhập
        Knapsack knapsack = new Knapsack(capacity);

        // Khởi tạo solver và giải bài toán
        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        // Tính toán giá trị tối đa
        int maxValue = solver.solve();
        System.out.println("Giá trị tối đa đạt được: " + maxValue);

        // Lấy các vật phẩm được chọn
        List<Item> selectedItems = solver.getSelectedItems();

        // In ra số vật phẩm đã chọn và chi tiết các vật phẩm đó
        System.out.println("Số vật phẩm đã chọn: " + selectedItems.size());
        for (Item item : selectedItems) {
            System.out.println(item);
        }

        // Đóng scanner
        scanner.close();
    }
}

