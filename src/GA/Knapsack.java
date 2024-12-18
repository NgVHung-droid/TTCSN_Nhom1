package GA;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private double capacity;
    private List<Item> items;
    private List<Item> selectedItems;
    private double totalValue;
    private double totalWeight;

    public Knapsack(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
        this.selectedItems = new ArrayList<>();
        this.totalValue = 0.0;
        this.totalWeight = 0.0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void solve() {
        // Sắp xếp các vật phẩm theo tỷ lệ value/weight giảm dần
        items.sort((o1, o2) -> Double.compare(o2.getValuePerWeight(), o1.getValuePerWeight()));

        double remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity == 0) break;

            if (item.getWeight() <= remainingCapacity) {
                // Chọn toàn bộ vật phẩm
                selectedItems.add(item);
                totalValue += item.getValue();
                totalWeight += item.getWeight();
                remainingCapacity -= item.getWeight();
            } else {
                // Chọn một phần vật phẩm
                double fraction = remainingCapacity / item.getWeight();
                selectedItems.add(new Item(item.getValue() * fraction, remainingCapacity));
                totalValue += item.getValue() * fraction;
                totalWeight += remainingCapacity;
                remainingCapacity = 0;
            }
        }
    }

    public double getTotalValue() {
        return totalValue;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }
}
