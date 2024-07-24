package utils;

public interface List<E> {
    boolean add(E item);

    void add(int index, E item);

    boolean addAll(List<E> otherList);

    void clear();

    boolean contains(E item);

    E get(int index);

    int indexOf(E item);

    boolean isEmpty();

    E remove(int index);

    boolean remove(E item);

    E set(int index, E item);

    int size();

    //FIXME: default methods not implemented
    /**
     * adds the item as the first element in the list.
     * @param item the data.
     */
    void addFirst(E item);

    /**
     * adds the item as the last element in the list.
     * @param item the data.
     */
    void addLast(E item);

    /**
     * retrieves the first item in the list.
     * @return the first data of hte list.
     */
    E getFirst();

    /**
     * retrieves the first item in the list.
     * @return the data.
     */
    E getLast();

    /**
     * removes the first item from the list.
     * @return the data of the first removed.
     */
    E removeFirst();

    /**
     * removes the last item from the list.
     * @return the data of the last removed.
     */
    E removeLast();

    Iterator<E> iterator();

}
