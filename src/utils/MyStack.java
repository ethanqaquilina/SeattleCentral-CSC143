package utils;


import java.util.EmptyStackException;

public class MyStack<E> {

    Node<E> first;

    Node<E> last;

    int size;

    public MyStack() {
        size = 0;
        first = null;
        last = null;
    }

    private E detach() {
        Node removedNode = first;
        first = first.next;
        removedNode.next = null;
        size--;
        return (E) removedNode.data;


    }

    public E push(E item) {
        if (isEmpty()) {
            last = new Node<>(item, null);
            first = last;
        } else if (first == last) {
            first = new Node<>(item, last);
        } else {
            first = new Node<>(item, first);
        }
        size++;
        return item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return detach();
    }


    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return first.data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 && first == null;
    }

    public String toString() {

        ArrayList<E> list = new ArrayList();

        int curSize = size;


        if (isEmpty()) {
            return "[]";
        } else {
            // pops out the stack to collect into the array
            for (int i = curSize; 0 < i; i--) list.add(pop());

            //creates the string with string builder
            StringBuilder resultList = new StringBuilder("[" + list.get(list.size() - 1));
            for (int i = list.size() - 2; i >= 0; i--) {
                resultList.append(", ").append(list.get(i));
            }
            resultList.append("]");

            //returns items back to the stack
            for (int i = 0; i < curSize; i++) {
                push(list.remove(list.size() - 1));
            }

            return resultList.toString();
        }

    }

    static class Node<E> {

        E data;

        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }


    }


}
