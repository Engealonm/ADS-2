
class MyStack<T> {
    private Mylist<T> list;

    public MyStack() {
        list = new Mylinkedlist<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
