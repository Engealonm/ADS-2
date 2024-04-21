import java.util.Iterator;

public class Mylinkedlist<T> implements Mylist<T>{
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public Mylinkedlist() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(item);
        else if (index == size)
            addLast(item);
        else {
            Node newNode = new Node((T) item);
            Node current = getNode(index);
            Node prev = current.prev;
            newNode.next = current;
            newNode.prev = prev;
            prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        Node nodeToRemove = getNode(index);
        Node prev = nodeToRemove.prev;
        Node next = nodeToRemove.next;
        if (prev != null)
            prev.next = next;
        else
            head = next;
        if (next != null)
            next.prev = prev;
        else
            tail = prev;
        nodeToRemove.data = null;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        remove(size - 1);
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if (object.equals(current.data))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public int LastIndexOf(Object object) {
        int index = size - 1;
        for (Node current = tail; current != null; current = current.prev) {
            if (object.equals(current.data))
                return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }

    @Override
    public void clear() {
        while (head != null) {
            Node next = head.next;
            head.data = null;
            head.next = null;
            head.prev = null;
            head = next;
        }
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
