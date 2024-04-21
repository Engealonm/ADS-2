class MyQueue<T> {
    private Mylist<T> list;

    public MyQueue() {
        list = new Mylinkedlist<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
