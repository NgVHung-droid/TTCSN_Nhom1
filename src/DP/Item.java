package DP;

public class Item {
    private int weight;
    private int value;

    // Constructor cho Item
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    // Phương thức lấy trọng lượng của vật phẩm
    public int getWeight() {
        return weight;
    }

    // Phương thức lấy giá trị của vật phẩm
    public int getValue() {
        return value;
    }

    // Phương thức trả về chuỗi mô tả vật phẩm
    @Override
    public String toString() {
        return "Item{weight=" + weight + ", value=" + value + "}";
    }
}

