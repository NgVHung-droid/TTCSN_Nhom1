package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase2 {

    @Test
    public void testKnapsackWithZeroWeightItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(0, 10)); // Vật phẩm có trọng lượng 0 và giá trị 10
        items.add(new Item(0, 20)); // Vật phẩm có trọng lượng 0 và giá trị 20
        Knapsack knapsack = new Knapsack(5); // Túi có sức chứa 5

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertEquals(30, maxValue); // Giá trị tối đa là 30 vì tất cả các vật phẩm có trọng lượng 0 và đều có thể được chọn
    }
}
