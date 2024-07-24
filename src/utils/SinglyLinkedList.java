package utils;


@SuppressWarnings("ALL")
public class SinglyLinkedList<T> {

    private Node first;

    private int size;

    public SinglyLinkedList() {
        first = null;
        size = 0;
    }

    public boolean add(T item) {
        append(item);
        return true;
    }

    public void add(int index, T item) {
        if (index != size) {
            insertBefore(index, item);
        } else {
            append(item);
        }

    }

    private void append(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node endNode = node(size - 1);
            endNode.next = newNode;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

    private T detach(int index) {
        checkIndex(index);
        Node detachedNode = new Node(index);
        if (index == 0) {
            first = first.next;
        } else {
            Node nodeBefore = node(index - 1);
            Node targetNode = nodeBefore.next;
            nodeBefore.next = targetNode.next;
        }
        size--;
        return (T) detachedNode.data;

    }

    public T get(int index) {
        checkIndex(index);
        T data = (T) node(index).data;
        return data;

    }


    private void insertBefore(int index, T item) {
        if (index == 0) {
            first = new Node(item, first);
        } else {
            checkIndex(index);
            Node nodeBefore = node(index - 1);
            Node targetNode = nodeBefore.next;
            nodeBefore.next = new Node(item, targetNode);
        }
        size++;

    }

    public boolean isEmpty() {
        return first == null && size == 0;

    }

    private Node node(int index) {
        checkIndex(index);
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T remove(int index) {
        T removedData = (T) node(index).data;
        detach(index);
        return (T) removedData;
    }

    public T set(int index, T item){
        T nodeData = (T) node(index).data;
        insertBefore(index, item);
        detach(index + 1);
        return nodeData;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }

    }


    private static class Node<E> {

        public E data;

        public Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }
}
