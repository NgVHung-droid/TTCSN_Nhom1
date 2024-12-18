package DP;

public class Knapsack {
    private int capacity; // Sức chứa của túi

    // Constructor cho Knapsack
    public Knapsack(int capacity) {
        this.capacity = capacity;
    }

    // Phương thức lấy sức chứa của túi
    public int getCapacity() {
        return capacity;
    }

    // Phương thức kiểm tra nếu một vật phẩm có thể được chọn hay không
    public boolean canFitItem(Item item) {
        return item.getWeight() <= this.capacity;
    }
}
