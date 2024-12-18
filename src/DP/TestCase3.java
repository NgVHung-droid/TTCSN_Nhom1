package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase3 {

    @Test
    public void testKnapsackWithZeroValueItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 0)); // Vật phẩm có trọng lượng 2 và giá trị 0
        items.add(new Item(3, 0)); // Vật phẩm có trọng lượng 3 và giá trị 0
        Knapsack knapsack = new Knapsack(5); // Túi có sức chứa 5

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertEquals(0, maxValue); // Giá trị tối đa là 0 vì không có vật phẩm nào có giá trị
    }
}
