package DP;

import java.util.ArrayList;
import java.util.List;

public class KnapsackSolver {
        private Knapsack knapsack; // Túi
        private List < Item > items; // Danh sách vật phẩm
        private int[][] dp; // Mảng dp lưu trữ giá trị tối đa

        // Constructor cho KnapsackSolver
        public KnapsackSolver(Knapsack knapsack, List < Item > items) {
                this.knapsack = knapsack;
                this.items = items;
                int n = items.size();
                this.dp = new int[n + 1][knapsack.getCapacity() + 1];
        }

        // Phương thức giải bài toán cái túi sử dụng quy hoạch động
        public int solve() {
                int n = items.size();
                for (int i = 0; i <= n; i++) {
                        dp[i][0] = 0; // Nếu sức chứa bằng 0, giá trị là 0
                }

                for (int j = 0; j <= knapsack.getCapacity(); j++) {
                        dp[0][j] = 0; // Nếu không có vật phẩm nào, giá trị là 0
                }

                for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= knapsack.getCapacity(); j++) {
                                Item item = items.get(i - 1);
                                if (item.getWeight() <= j) { // Nếu có thể chọn vật phẩm
                                        dp[i][j] = Math.max(
                                                dp[i - 1][j], // Không chọn vật phẩm
                                                item.getValue() + dp[i - 1][j - item.getWeight()] // Chọn vật phẩm
                                        );
                                } else {
                                        dp[i][j] = dp[i - 1][j]; // Nếu không thể chọn vật phẩm
                                }
                        }
                }
                return dp[n][knapsack.getCapacity()];
        }

        // Phương thức truy xuất các vật phẩm được chọn
        public List < Item > getSelectedItems() {
                List < Item > selectedItems = new ArrayList < > ();
                int w = knapsack.getCapacity();
                int n = items.size();

                for (int i = n; i > 0 && w > 0; i--) {
                        if (dp[i][w] != dp[i - 1][w]) { // Nếu vật phẩm được chọn
                                Item item = items.get(i - 1);
                                selectedItems.add(item);
                                w -= item.getWeight(); // Giảm sức chứa còn lại
                        }
                }
                return selectedItems;
        }
}

