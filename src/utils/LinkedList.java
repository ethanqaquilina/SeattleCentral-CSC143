package utils;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    /**
     * A constructor that is a default constructor initializes the starting
     * node location “first” and size to a zero equivalent, that is, constructs an empty list.
     */
    public LinkedList() {
        first = null;
        size = 0;

    }

    public LinkedList(List<E> otherList) {
        clear();
        addAll(otherList);
    }

    /**
     * uses the append method and ensures that there
     * is enough spaces to store each element in the
     * list. Also updates the number of elements  in
     * the list by one. This method returns true, if
     * the data was added successfully.
     *
     * @param item is added to the list
     * @return true or false if add was successful
     */
    public boolean add(E item) {
        append(item);
        size++;
        last = node(size - 1);
        return true;

    }


    /**
     * inserts elements at a given location in the list, shifting subsequent elements
     * to the right.  Uses the append and insertBefore methods to assist with adding
     * items to the front, back and middle of the list. Updates the number of elements
     * in the list by one.
     *
     * @param index of the node you want to insert.
     * @param item  the data of the node.
     */
    public void add(int index, E item) {
        if (isEmpty() || index == size) {
            append(item);
        } else {
            checkIndex(index);
            insertBefore(index, item);
        }
        size++;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
        }
        return true;
    }

    /**
     * inserts an item before the non-null node at the specified
     * index in the list. Traverses the list to find this node.
     * This method also checks for insertions at the start and
     * end of the list, as well as when empty. This is a private
     * helper method.
     *
     * @param index of the node you want to insert before.
     * @param item  data being placed.
     */
    private void insertBefore(int index, E item) {
        Node<E> newNode = new Node<>(null, item);
        if (index == 0) {
            Node<E> firstNode = node(0);
            firstNode.prev = newNode;
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> targetNode = node(index);
            Node<E> nodeBefore = targetNode.prev;
            nodeBefore.next = newNode;
            newNode.prev = nodeBefore;
            newNode.next = targetNode;
            targetNode.prev = newNode;
        }

    }

    /**
     * checks if the given index is valid. Validation means that
     * you cannot access indexes where elements have not been
     * placed. Throws an IndexOutOfBoundsException, if invalid.
     * This is a private helper method.
     *
     * @param index of the node you are checking.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

    /**
     * appends elements to the end of the list, but does not update
     * the number of elements. This is a private helper method.
     *
     * @param item data being added.
     */
    private void append(E item) {
        Node<E> newNode = new Node<>(null, item);
        if (isEmpty()) {
            first = newNode;
            last = first;
        } else {
            Node<E> endNode = node(size - 1);
            endNode.next = newNode;
            newNode.prev = endNode;
            last = newNode;
        }
    }

    /**
     * searches for a specific item within the linked structure
     * and returns true, if the item is in the list.
     *
     * @param item being searched for.
     * @return true or false if the item exists.
     */
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    /**
     * clears list of all elements, returns size back to zero.
     */
    public void clear() {
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            current.data = null;
            current = current.next;
        }
        size = 0;
    }

    /**
     * detaches the node at the specified index from list and returns
     * the deleted element, but does not reduce the size of the list.
     * This is a private helper method.
     *
     * @param index of the node you want to detach.
     * @return the data of the node detached.
     */
    private E detach(int index) {
        //FIXME: Make more efficient, there are unnecessary or redundant statements
        if (index == 0 && size == 1) {
            E firstData = first.data;
            first = null;
            size = 0;
            return firstData;
        } else if (index == 0) {
            E firstData = first.data;
            Node<E> nextFirst = first.next;
            first.next = null;
            nextFirst.prev = null;
            first = nextFirst;
            return firstData;

        } else if (index == size - 1) {
            Node<E> endNode = node(size - 1);
            last = node(size - 2);
            last.next = null;
            endNode.prev = null;
            return endNode.data;
        } else {
            //FIXME: Inefficient, you are calling a for loop twice
            Node<E> targetNode = node(index);
            Node<E> nodeBefore = node(index - 1);
            Node<E> nodeAfter = node(index + 1);
            nodeBefore.next = nodeAfter;
            nodeAfter.prev = nodeBefore;
            return targetNode.data;
        }
    }

    /**
     * returns the item at the specified position in the list. This
     * method first checks if the index requested is valid.
     *
     * @param index of the node you want to get data from.
     * @return the data of the node.
     */
    public E get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    /**
     * returns true, if the list is empty, i.e., the list contains no elements.
     *
     * @return true or false.
     */
    public boolean isEmpty() {
        return (first == null || size == 0);

    }

    /**
     * returns a reference to the node at the given position in the list. This node
     * traverses the list in two directions from front to middle and back to middle.
     * This is a private helper method.
     *
     * @param index of the node you are getting.
     * @return node object at the given index.
     */
    private Node<E> node(int index) {
        Node<E> current;
        if (index < size / 2) {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = 0; i < ((size - index) - 1); i++) {
                current = current.prev;
            }
        }
        return current;

    }

    /**
     * searches for a specific item within the linked structure and returns
     * the first occurrence (i.e. index location) in the list, otherwise
     * returns -1, if NOT found.
     *
     * @param item being searched for in the list.
     * @return the index of the item being searched for.
     */
    public int indexOf(E item) {
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * removes the item at the given position in the list for a valid index. Checks for
     * valid index before it proceeds with removal. Shifts subsequent elements to the left
     * and returns the item removed. The number of elements in the list is reduced by one.
     *
     * @param index of the node you want to remove.
     * @return the node data.
     */
    public E remove(int index) {
        checkIndex(index);
        E removedData = detach(index);
        if (size > 0) {
            size--;
        }
        return removedData;

    }

    /**
     * removes the first occurrence of the specified item from the list, if present. Shifts
     * subsequent elements to the left and returns true, if the item is removed. The number
     * of elements in the list is reduced by one.
     *
     * @param item the data of the node you want to remove.
     * @return true or false that the data was removed successfully.
     */
    public boolean remove(E item) {
        if (contains(item)) {
            detach(indexOf(item));
            size--;
            return true;
        }
        return false;
    }

    /**
     * replaces the item at the specified position with the one passed.
     * This method checks if the index requested is valid before it does
     * he replacement and returns the replaced item.
     *
     * @param index of the node you want to set.
     * @param item  the data you want to replace the target node with.
     * @return the data of the node replaced.
     */
    public E set(int index, E item) {
        checkIndex(index);
        E dataRemoved = node(index).data;
        node(index).data = item;
        return dataRemoved;
    }

    /**
     * returns the number of elements in the list.
     *
     * @return the size.
     */
    public int size() {
        return size;
    }

    /**
     * adds the item as the first element in the list.
     *
     * @param item the data.
     */
    @Override
    public void addFirst(E item) {
        add(0, item);
    }

    /**
     * adds the item as the last element in the list.
     *
     * @param item the data.
     */
    @Override
    public void addLast(E item) {
        add(item);
    }

    /**
     * retrieves the first item in the list, throws a NoSuchElementException, if list is empty.
     *
     * @return data of the first node.
     */
    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty.");
        }
        return first.data;
    }

    /**
     * retrieves the last item in the list, throws a NoSuchElementException, if list is empty.
     *
     * @return the data of the last node.
     */
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty.");
        }
        return last.data;
    }

    /**
     * removes the first item from the list, and returns item, throws a NoSuchElementException, if list is empty.
     *
     * @return the data of the first node removed.
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty.");
        }
        return remove(0);
    }

    /**
     * removes the last item from the list, and returns item, throws a NoSuchElementException, if list is empty.
     *
     * @return the last data of the node removed.
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty.");
        }
        return remove(size - 1);
    }

    /**
     * displays the contents of the list according to the same format at shown in the Java API.
     *
     * @return the result of the String Builder.
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }



    private static class Node<E> {

        public E data;

        public Node<E> next;

        public Node<E> prev;

        /**
         * A constructor that receives parameters for data, and prev and calls the second constructor.
         *
         * @param prev the node before.
         * @param data the data of the node.
         */
        public Node(Node<E> prev, E data) {
            this(prev, data, null);

        }

        /**
         * A constructor that receives parameters for  data, next and prev.
         *
         * @param prev the node before.
         * @param data the data of the node.
         * @param next the node next.
         */
        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;

        }
    }


    private class LinkedIterator implements Iterator {
        private Node current;

        private final LinkedList<E> list;
        private boolean isAbleToRemove;
        private int position;          // current position in list

        public LinkedIterator(LinkedList<E> currentList) {
            list = currentList;
            current = first;
            isAbleToRemove = false;
        }

        public boolean hasNext() {
            return position < list.size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next value!");
            }
            current = current.next;
            position++;
            isAbleToRemove = true;
            return (E) current.prev.data;
        }

        public void remove() {
            if (!isAbleToRemove) {
                throw new IllegalStateException("Not Able To Remove.");
            }
            list.remove(position - 1);
            position--;
            isAbleToRemove = false;
        }
    }

    public LinkedIterator iterator() {
        return new LinkedIterator(this);
    }

}
