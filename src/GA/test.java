package GA;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class test {

    private Knapsack knapsack;

    // Phương thức này sẽ được gọi trước mỗi bài kiểm thử để thiết lập môi trường kiểm thử
    @Before
    public void setUp() {
        // Mỗi phương thức kiểm thử sẽ khởi tạo một đối tượng Knapsack mới
        knapsack = new Knapsack(50); // Mặc định túi có sức chứa là 50
    }

    // Test trường hợp không có vật phẩm
    @Test
    public void testNoItems() {
        knapsack.solve();
        
        // Kết quả mong đợi là không có vật phẩm nào được chọn và tổng giá trị = 0
        assertEquals(0.0, knapsack.getTotalValue(), 0.01);
        assertEquals(0.0, knapsack.getTotalWeight(), 0.01);
        assertTrue(knapsack.getSelectedItems().isEmpty()); // Danh sách vật phẩm được chọn rỗng
    }

    // Test trường hợp sức chứa túi là 0
    @Test
    public void testZeroCapacity() {
        knapsack = new Knapsack(0); // Tạo túi với sức chứa 0
        knapsack.addItem(new Item(60, 10)); // Thêm một vật phẩm
        knapsack.addItem(new Item(100, 20));
        knapsack.addItem(new Item(120, 30));
        knapsack.solve();
        
        // Kết quả mong đợi là không có vật phẩm nào được chọn vì sức chứa là 0
        assertEquals(0.0, knapsack.getTotalValue(), 0.01);
        assertEquals(0.0, knapsack.getTotalWeight(), 0.01);
        assertTrue(knapsack.getSelectedItems().isEmpty()); // Danh sách vật phẩm được chọn rỗng
    }

    

    

    // Test trường hợp chỉ có một vật phẩm vừa vặn với túi
    @Test
    public void testOneItemFitsExactly() {
        knapsack.addItem(new Item(500, 50)); // Vật phẩm có thể chứa hết túi
        knapsack.addItem(new Item(100, 20));
        knapsack.addItem(new Item(150, 30));
        knapsack.solve();
        
        // Kết quả mong đợi là chỉ có vật phẩm với giá trị 500 được chọn
        assertEquals(500.0, knapsack.getTotalValue(), 0.01);
        assertEquals(50.0, knapsack.getTotalWeight(), 0.01);
        assertEquals(1, knapsack.getSelectedItems().size()); // Chỉ có một vật phẩm được chọn
    }

    // Test trường hợp tất cả vật phẩm có giá trị và trọng lượng giống nhau
    @Test
    public void testItemsWithEqualValueAndWeight() {
        knapsack.addItem(new Item(60, 10));  // Tất cả các vật phẩm có giá trị và trọng lượng giống nhau
        knapsack.addItem(new Item(60, 10));
        knapsack.addItem(new Item(60, 10));
        knapsack.solve();
        
        // Kết quả mong đợi là tất cả các vật phẩm đều được chọn vì trọng lượng không vượt quá sức chứa của túi
        assertEquals(180.0, knapsack.getTotalValue(), 0.01);  // Tổng giá trị là 60 * 3
        assertEquals(30.0, knapsack.getTotalWeight(), 0.01); // Tổng trọng lượng là 10 * 3
        assertEquals(3, knapsack.getSelectedItems().size()); // Ba vật phẩm được chọn
    }

    
}
