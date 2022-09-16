package ADT_Bag;


public class Bag<T> implements BagInterface<T> {

    private static int intialCapacity;
    private T[] bag = (T[]) new Object[intialCapacity];
    private static int numOfEntries = 0;

    public Bag() {
        this.intialCapacity = 16;
    }

    public Bag(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        bag = temp;
    }

    public int getCurrentSize() {
        return bag.length;
    }

    public boolean isEmpty() {
        return bag.length > 0 ? false : true;
    }

    public boolean add(T newEntry) {
        try {
            bag[numOfEntries] = newEntry;
            System.out.println(bag[numOfEntries]);
            numOfEntries++;
            return true;
        } catch (Exception RuntimeException) {
            return false;
        }
    }

    public void clear() {
        for(int i = 0; i < bag.length; i++)
            bag[i] = null;
    }

    public boolean contains(T anEntry) {
        for (T o : bag)
            return anEntry == o ? true : false;
        return false;
    }

    public int getFrequencyOf(T anEntry) {

        return 0;
    }

    public T remove() {
        T remove = bag[numOfEntries];
        bag[numOfEntries] = null;
        numOfEntries--;
        return remove;
    }

    public boolean remove(T anEntry) {
        
        return false;
    }

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {

        return null;
    }
}
