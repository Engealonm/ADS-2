class MyMinHeap<T extends Comparable<T>> {
    private Mylist<T> list;

    public MyMinHeap() {
        list = new Myarraylist<>();
    }

    public void insert(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        T min = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(0, list.get(lastIndex));
        list.remove(lastIndex);
        heapifyDown(0);
        return min;
    }

    public T peekMin() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0)
                break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int size = list.size();
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int minIndex = index;
            if (leftChildIndex < size && list.get(leftChildIndex).compareTo(list.get(minIndex)) < 0)
                minIndex = leftChildIndex;
            if (rightChildIndex < size && list.get(rightChildIndex).compareTo(list.get(minIndex)) < 0)
                minIndex = rightChildIndex;
            if (minIndex == index)
                break;
            swap(index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}