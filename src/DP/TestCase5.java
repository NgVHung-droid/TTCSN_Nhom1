package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase5 {

    @Test
    public void testKnapsackWithLargeNumberOfItems() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            items.add(new Item(i, i)); // Tạo 1000 vật phẩm với trọng lượng và giá trị đều bằng i
        }
        Knapsack knapsack = new Knapsack(5000); // Túi có sức chứa 5000

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertTrue(maxValue > 0); // Kiểm tra giá trị tối đa có phải là số dương
    }
}
