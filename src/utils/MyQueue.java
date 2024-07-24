package utils;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    Node<E> first;

    Node<E> last;

    int size;

    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(E item) {
        append(item);
        size++;
        return true;

    }

    private void append(E item) {
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        } else {
            last.next = new Node<>(item);
            last = last.next;
        }

    }

    private E detach() {

        Node nodeNext = first;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return (E) nodeNext.data;
    }

    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E removedData = detach();
        size--;
        return removedData;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return first.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return ((size == 0) && (first == null));
    }

    public String toString() {

        ArrayList<E> list = new ArrayList();

        int curSize = size;


        if (isEmpty()) {
            return "[]";
        } else {
            // removes from queue to collect into the array
            for (int i = curSize; 0 < i; i--) list.add(remove());

            //creates the string with string builder
            StringBuilder resultList = new StringBuilder("[" + list.get(0));
            for (int i = 1; i < list.size(); i++) {
                resultList.append(", ").append(list.get(i));
            }
            resultList.append("]");

            //returns items back to the queue;
            for (int i = 0; i < curSize; i++) {
                add(list.remove(0));
            }

            return resultList.toString();
        }
    }


    private static class Node<E> {
        E data;

        Node<E> next;

        public Node(E data) {
            this(data, null);

        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
