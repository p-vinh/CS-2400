package ADT_Bag;

<<<<<<< HEAD:ArrayBag.java
// "final" cant have a subclass
public final class ArrayBag<T> implements BagInterface<T> {
=======
import java.util.Arrays;

public class Bag<T> implements BagInterface<T> {
>>>>>>> ad58f71b63042b425436bfc63cec27b9d546013a:ADT_Bag/Bag.java

    private static final int DEFAULT_CAPACITY = 25;
    private T[] bag;
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
            doubleCapacity();
        }
        bag[numOfEntries] = newEntry;
        numOfEntries++;

        return result;
    }

    public void clear() {
        while(!isEmpty()) {
            remove();
        }
    }

    public boolean contains(T anEntry) {
        checkIntegrity();
        // return anEntry.equals(bag[getIndexOf(anEntry)]);
        return getIndexOf(anEntry) >= -1; // or >= 0;   
    }

    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int counter = 0;

        for(int i = 0; i < numOfEntries; i++)
            if (anEntry.equals(bag[i]))
                counter++;
        return counter;
    }

    /** Removes one unspecified entry from this bag, if possible.
     *  @return Either the removed entry, if the removal was successful, or null otherwise.
     */
    public T remove() {
<<<<<<< HEAD:ArrayBag.java
        try {
            if (!isEmpty()) {
                numOfEntries--;
                return bag[numOfEntries];
            }
        } catch (Exception RuntimeException) {
            return null;
        }
        return null;
=======
        checkIntegrity();
        T result = removeEntry(numOfEntries - 1);
        return result;
>>>>>>> ad58f71b63042b425436bfc63cec27b9d546013a:ADT_Bag/Bag.java
    }

    public boolean remove(T anEntry) {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
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

    // Removes and returns the entry at a given index within the array bag.
    // If no such entry exist, returns null
        // Precondition: 0 <= givenIndex < numberOfEntries;
    //            checkIntegrity has been called.
    private T removeEntry(int givenIndex) {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex]; // Entry to remove
            bag[givenIndex] = bag[numOfEntries - 1]; // Replace entry with the last entry
            bag[numOfEntries - 1] = null; // Remove last entry
            numOfEntries--;
        }
        return result;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numOfEntries)) {
            if(anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array
        return where;
    }

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if(capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    // Doubles the size of the array bag.
    // Precondition: checkIntegrity has been called.
    private void doubleCapacity() {
        int newLength = bag.length * 2;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }
}
