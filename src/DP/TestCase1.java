package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase1 {

    @Test
    public void testKnapsackWithZeroCapacity() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 10)); // Vật phẩm với trọng lượng 1 và giá trị 10
        items.add(new Item(2, 20)); // Vật phẩm với trọng lượng 2 và giá trị 20
        Knapsack knapsack = new Knapsack(0); // Túi có sức chứa bằng 0

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertEquals(0, maxValue); // Giá trị tối đa là 0 vì không thể chọn vật phẩm nào
    }
}
