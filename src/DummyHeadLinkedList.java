public class DummyHeadLinkedList<T> implements List<T>
{
    /**
     * Node class stores a value and next node
     * @param <T> type of element
     */
    static class Node<T>
    {
        T value;
        Node<T> next;

        public Node(T value)
        {
            this.value = value;
        }
    }

    private final Node<T> head;
    private int size;

    public DummyHeadLinkedList()
    {
        this.head = new Node<>(null);
        this.size = 0;
    }

    /**
     * Add element to list at given index
     * @param index index to add element to
     * @param element element to add
     */
    @Override
    public void add(int index, T element)
    {
        //make sure index is valid
        if(index > this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<>(element);

        //find prev of node
        Node<T> cur = this.head;

        for(int i = 0; i < index - 1; i++)
        {
            cur = cur.next;
        }

        //add node
        node.next = cur.next;
        cur.next = node;

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
        Node<T> node = new Node<>(element);

        //add to start
        node.next = this.head.next;
        this.head.next = node;

        this.size++;

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
        //make sure index is valid
        if(index >= this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        //traverse until node is reached
        Node<T> cur = this.head.next;

        for(int i = 0; i < index; i++)
        {
            cur = cur.next;
        }

        return cur.value;
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

        //find prev of node
        Node<T> cur = this.head;

        for(int i = 0; i < index; i++)
        {
            cur = cur.next;
        }

        T val = cur.next.value;

        //remove node
        cur.next = cur.next.next;
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