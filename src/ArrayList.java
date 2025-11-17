public class ArrayList<T> implements List<T>
{
    private T[] arr;
    private int size;

    /**
     * Create a new arraylist with starting size 10
     */
    public ArrayList()
    {
        this.arr = (T[]) new Object[10];
        this.size = 0;
    }

    /**
     * Grow the size of the array by a factor of 1.5
     */
    private void grow()
    {
        T[] newArr = (T[]) new Object[(int) (this.size * 1.5)];

        for(int i = 0; i < this.size; i++)
        {
            newArr[i] = this.arr[i];
        }

        this.arr = newArr;
    }

    /**
     * Shifts elements of arr to the right
     * @param idx leftmost index to shift right
     */
    private void shiftR(int idx)
    {
        for(int i = this.size; i > idx; i--)
        {
            this.arr[i] = this.arr[i - 1];
        }

        this.arr[idx] = null;
    }

    /**
     * Shifts elements of arr to the left
     * @param idx rightmost index to shift left
     */
    private void shiftL(int idx)
    {
        if(idx == 0)
        {
            throw new RuntimeException("CANNOT SHIFT ELEMENT AT INDEX 0 TO THE LEFT!");
        }

        for(int i = idx - 1; i < this.size - 1; i++)
        {
            this.arr[i] = this.arr[i + 1];
        }

        this.arr[this.size - 1] = null;
    }

    /**
     * Add element to list at given index
     * @param index index to add element to
     * @param element element to add
     */
    @Override
    public void add(int index, T element)
    {
        if(index > this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        //grow array if needed
        if(this.arr.length == this.size)
        {
            grow();
        }

        //make space for new element
        shiftR(index);

        this.arr[index] = element;

        this.size++;
    }

    /**
     * Add element to end of list
     * @param element element to add
     * @return true if successful, false if not
     */
    @Override
    public boolean add(T element)
    {
        //grow array if needed
        if(this.arr.length == this.size)
        {
            grow();
        }

        //insert at end of array
        this.arr[this.size++] = element;

        return true;
    }

    /**
     * Get the element at the given index
     * @param index index to get value of
     * @return value at list[index]
     */
    @Override
    public T get(int index)
    {
        if(index >= this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        return this.arr[index];
    }

    /**
     * Remove element at given index
     * @param index index to remove
     * @return value of element removed
     */
    @Override
    public T remove(int index)
    {
        //make sure index is valid
        if(index >= this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        T val = this.arr[index];

        //fill in empty space
        shiftL(index + 1);

        this.size--;

        return val;
    }

    /**
     * @return number of elements in list
     */
    @Override
    public int size()
    {
        return this.size;
    }
}
