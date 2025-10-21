/**
 * Interface for a general list
 * @param <T> type the list holds
 */
public interface List<T> {

    /**
     * Add element to list at given index
     * @param index index to add element to
     * @param element element to add
     */
    public void add (int index, T element);

    /**
     * Add element to end of list
     * @param element element to add
     * @return true if successful, false if not
     */
    public boolean add (T element);

    /**
     * Get the element at the given index
     * @param index index to get value of
     * @return value at list[index]
     */
    public T get (int index);

    /**
     * Remove element at given index
     * @param index index to remove
     * @return value of element removed
     */
    public T remove (int index);

    /**
     * @return number of elements in list
     */
    public int size ();
}
