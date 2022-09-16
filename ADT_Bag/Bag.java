package ADT_Bag;

public class Bag<T> implements BagInterface<T> {

    private static final int DEFAULT_CAPACITY = 25;
    private final T[] bag;
    private int numOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    public Bag() {
        this(DEFAULT_CAPACITY);
    }

    public Bag(int capacity) {

        if (capacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[capacity];
            bag = temp;
            numOfEntries = 0;
            integrityOK = true;
        }
        else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize() {
        return bag.length;
    }

    public boolean isEmpty() {

        for (int i = 0; i < bag.length; i++) {
            if (bag[i] != null)
                return true;
        }
        return false;
    }

    public boolean add(T newEntry) {
        boolean result = true;
        if(isArrayFull()) {
            result = false;
        }
        else {
            bag[numOfEntries] = newEntry;
            numOfEntries++;
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < bag.length; i++)
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
        try {
            System.out.println(!isEmpty());
            if (!isEmpty()) {
                numOfEntries--;
                return bag[numOfEntries];
            }
        } catch (Exception RuntimeException) {
            return null;
        }
        return null;
    }

    public boolean remove(T anEntry) {

        return false;
    }

    /**
     * Retrieves all entries that are in this bag.
     * 
     * @return A newly allocated array of all the entries in the bag.
     *         Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        //The cast is safe because the new array, contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numOfEntries];

        for (int index = 0; index < result.length; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    private boolean isArrayFull() {
        return numOfEntries >= bag.length;
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Bag Object is corrupt");
        }
    }
}
