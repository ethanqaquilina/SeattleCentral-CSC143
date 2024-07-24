package utils;

import java.util.NoSuchElementException;

@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class ArrayList<E> implements List<E> {

    private int size;
    private E[] array;
    public static final int DEFAULT_CAPACITY = 10;

    //First Constructor
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    //Second Constructor
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        } else {
            array = (E[]) new Object[capacity];
            size = 0;
        }
    }


    public ArrayList(List<E> otherList) {
        array = (E[]) new Object[otherList.size()];
        for (int i = 0; i < otherList.size(); i++) {
            array[i] = otherList.get(i);
            size++;
        }
    }

    @Override
    public boolean add(E item) {
        if (size == array.length) {
            ensureCapacity(size + 1);
        }
        array[size] = item;
        size++;
        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index != size) {
            checkIndex(index);
        }
        if (size == array.length) {
            ensureCapacity(size + 1);
        }
        shiftRight(index);
        array[index] = item;
        size++;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        if (otherList.size() + size > array.length) {
            ensureCapacity(otherList.size() + size);
        }
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
        }
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) array[i] = null;
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    public void ensureCapacity(int targetCapacity) {

        if (targetCapacity > array.length * 2) {
            E[] newSizeArray = (E[]) new Object[targetCapacity];
            System.arraycopy(array, 0, newSizeArray, 0, array.length);
            array = newSizeArray;

        } else if (targetCapacity > array.length) {
            E[] newSizeArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newSizeArray, 0, array.length);
            array = newSizeArray;
        }

    }

    @Override
    public boolean equals(Object obj) {
        ArrayList<E> newObj = (ArrayList<E>) obj;
        if (size == newObj.size()) {
            for (int i = 0; i < size; i++) {
                if (array[i] != newObj.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedItem = array[index];
        shiftLeft(index);
        size--;
        return removedItem;
    }

    @Override
    public boolean remove(E item) {
        if (indexOf(item) == -1) {
            return false;
        } else {
            remove(indexOf(item));
            return true;
        }
    }

    @Override
    public E set(int index, E item) {
        checkIndex(index);
        E replacedItem = array[index];
        array[index] = item;
        return replacedItem;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E item) {
        add(0, item);
    }

    @Override
    public void addLast(E item) {
        add(size, item);
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return array[0];
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return array[size - 1];
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E firstItem = array[0];
        shiftLeft(0);
        size--;
        return firstItem;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E lastItem = array[size - 1];
        size--;
        return lastItem;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder resultList = new StringBuilder("[" + array[0]);
            for (int i = 1; i < size; i++) {
                resultList.append(", ").append(array[i]);
            }
            resultList.append("]");
            return resultList.toString();
        }
    }


    private class ArrayIterator implements Iterator<E> {
        private int index;   // current position in list
        private final ArrayList list;
        private boolean isAbleToRemove;


        public ArrayIterator(ArrayList<E> currentList) {
            list = currentList;
            index = 0;
            isAbleToRemove = false;
        }

        public boolean hasNext() {
            return index < list.size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next value");
            }
            index++;
            isAbleToRemove = true;
            return (E) list.get(index-1);
        }

        public void remove() {
            if (!isAbleToRemove) {
                throw new IllegalStateException("Not Able To Remove.");
            }
            list.remove(index - 1);
            index--;
            isAbleToRemove = false;
        }


    }

    public Iterator<E> iterator() {
        return new ArrayIterator(this);
    }
}
