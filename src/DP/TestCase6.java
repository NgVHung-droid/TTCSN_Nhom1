package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase6 {

    @Test
    public void testKnapsackWithAllItemsTooHeavy() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(6, 10));
        items.add(new Item(7, 20));
        items.add(new Item(8, 30));
        Knapsack knapsack = new Knapsack(5); // Túi có sức chứa 5, nhỏ hơn trọng lượng của tất cả các vật phẩm

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertEquals(0, maxValue); // Giá trị tối đa là 0 vì không có vật phẩm nào có thể cho vào túi
    }
}

