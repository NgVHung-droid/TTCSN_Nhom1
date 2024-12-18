package GA;

public class Item {
    private double value;
    private double weight;
    private double valuePerWeight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
        this.valuePerWeight = value / weight;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public double getValuePerWeight() {
        return valuePerWeight;
    }

    @Override
    public String toString() {
        return String.format("Item{giá trị = %.2f, trọng lượng = %.2f, giá trị / trọng lượng = %.2f}", 
                             value, weight, valuePerWeight);
    }
}
