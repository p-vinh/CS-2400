package ADT_Bag;

import java.util.ArrayList;

public class Bag<Item> implements BagInterface<Item> {

    private ArrayList<Item> items = new ArrayList<>(3);

    public int getCurrentSize() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size() > 0 ? false : true;
    }

    public boolean add(Item newEntry) {
        try {
            items.add(newEntry);
            return true;
        } catch (Exception RuntimeException) {
            return false;
        }

    }

    public void clear() {
        items.clear();
    }

    public boolean contains(Item anEntry) {
        for (Item o : items)
            return anEntry == o ? true : false;
        return false;
    }

    public int getFrequencyOf(Item anEntry) {

        return 0;
    }

    public Item remove() {
        try {
            if(!isEmpty()) {
                Item i = items.get(0);
                items.remove(0);
                return i;
            }
        } catch (Exception RuntimeException) {
            return null;
        }
        return null;
    }

    public boolean remove(Item anEntry) {

        return false;
    }

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public Item[] toArray() {

        return null;
    }
}
