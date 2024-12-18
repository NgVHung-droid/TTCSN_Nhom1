package DP;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestCase4 {

    @Test
    public void testKnapsackWithNoItems() {
        List<Item> items = new ArrayList<>(); // Không có vật phẩm nào
        Knapsack knapsack = new Knapsack(10); // Túi có sức chứa 10

        KnapsackSolver solver = new KnapsackSolver(knapsack, items);

        int maxValue = solver.solve();
        assertEquals(0, maxValue); // Giá trị tối đa là 0 vì không có vật phẩm nào
    }
}
