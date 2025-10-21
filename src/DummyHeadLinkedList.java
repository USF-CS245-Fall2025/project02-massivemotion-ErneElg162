
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
    }

    private final Node<T> head;
    private Node<T> tail;

    private int size;

    public DummyHeadLinkedList()
    {
        this.head = new Node<>();
        this.tail = this.head;
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
        Node<T> cur = this.head.next;

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

        //find prev of node
        Node<T> cur = this.head;

        for(int i = 0; i < index; i++)
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
