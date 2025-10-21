
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
    }

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public LinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(int index, T element)
    {
        //make sure index is valid
        if(index > this.size)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<>();
        node.value = element;

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

        //new tail
        if(node.next == null)
        {
            this.tail = node;
        }

        this.size++;
    }

    @Override
    public boolean add(T element)
    {
        Node<T> node = new Node<>();
        node.value = element;

        //account for empty list
        if(this.head == null)
        {
            this.head = node;
            this.tail = node;
            this.size = 1;
            return true;
        }

        //add to end
        this.tail.next = node;
        this.tail = node;

        this.size++;

        return true;
    }

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
            this.tail = null;
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

        //remove tail
        if(index == this.size - 1)
        {
            this.tail = cur;
            this.tail.next = null;
            this.size--;

            return val;
        }

        //remove node
        cur.next = cur.next.next;
        this.size--;
        return val;
    }

    @Override
    public int size()
    {
        return this.size;
    }
}
