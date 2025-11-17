
public class LinkedList<T> implements List<T>
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

    private Node<T> head;

    private int size;

    public LinkedList()
    {
        this.head = null;
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

        //new head
        if(index == 0)
        {
            node.next = head;
            this.head = node;
            this.size++;
            return;
        }

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

        //account for empty list
        if(this.head == null)
        {
            this.head = node;
            this.size = 1;
            return true;
        }

        //add to start
        node.next = this.head;
        this.head = node;

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
        Node<T> cur = this.head;

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

        //account for only 1 element in list
        if(this.size == 1)
        {
            T val = head.value;

            this.head = null;
            this.size = 0;

            return val;
        }

        //remove head
        if(index == 0)
        {
            T val = head.value;

            head = head.next;
            size--;
            return val;
        }

        //find prev of node
        Node<T> cur = this.head;

        for(int i = 0; i < index - 1; i++)
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
