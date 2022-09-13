package ADT_Bag;

public class Item {
    private String itemName;
    private int costOfItem;

    public Item(String name, int cost) {
        this.itemName = name;
        this.costOfItem = cost;
    }

    public int getPrice() {
        return this.costOfItem;
    }

    public String getName() {
        return this.itemName;
    }

    @Override
    public String toString() {
        return String.valueOf(itemName + "\t$" + costOfItem / 100 + "." + costOfItem % 100);
    }
}
