package ADT_Bag;

// "final" cant have a subclass
public final class ArrayBag<T> implements BagInterface<T> {

    private static final int DEFAULT_CAPACITY = 25;
    private final T[] bag;
    private int numOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    public ArrayBag() {
        this(DEFAULT_CAPACITY); // Passes down int to another constructer with int param
    }

    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[capacity]; // Unchecked cast
            bag = temp;
            numOfEntries = 0;
            integrityOK = true;
        }
        else {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }
    }

    public int getCurrentSize() {
        return numOfEntries;
    }

    public boolean isEmpty() {
        return numOfEntries == 0;
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
        while(!isEmpty()) {
            remove();
        }
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

    /**
     * Checks if the bag is full
     * @return True or False if the number of entries is equal or greater than the bag capacity
     */
    private boolean isArrayFull() {
        return numOfEntries >= bag.length;
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("Bag Object is corrupt");
        }
    }
}
