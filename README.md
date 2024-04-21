ADS 2
Documentation of code
/**
* Interface representing a generic list data structure.
* @param <T> the type of elements in the list
  */
  interface MyList<T> extends Iterable<T> {
  // Methods for basic list operations
  void add(T item);
  void set(int index, T item);
  void add(int index, T item);
  void addFirst(T item);
  void addLast(T item);
  T get(int index);
  T getFirst();
  T getLast();
  void remove(int index);
  void removeFirst();
  void removeLast();
  void sort();
  int indexOf(Object object);
  int lastIndexOf(Object object);
  boolean exists(Object object);
  Object[] toArray();
  void clear();
  int size();
  }


* Implementation of a list using an array.
* @param <T> the type of elements in the list
  */
  class MyArrayList<T> implements MyList<T> {
  // Implementation details omitted for brevity
  }


* Implementation of a doubly linked list.
* @param <T> the type of elements in the list
  */
  class MyLinkedList<T> implements MyList<T> {
  // Implementation details omitted for brevity
  }


* Implementation of a stack using a linked list.
* @param <T> the type of elements in the stack
  */
  class MyStack<T> {
  // Implementation details omitted for brevity
  }


* Implementation of a queue using a linked list.
* @param <T> the type of elements in the queue
  */
  class MyQueue<T> {
  // Implementation details omitted for brevity
  }


* Implementation of a minimum heap using a list.
* @param <T> the type of elements in the heap (must be Comparable)
  */
  class MyMinHeap<T extends Comparable<T>> {
  // Implementation details omitted for brevity
  }

