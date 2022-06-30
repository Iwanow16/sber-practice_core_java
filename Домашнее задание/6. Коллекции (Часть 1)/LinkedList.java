import java.util.*;

public class LinkedList<E> implements List<E>, Deque<E> {

    private Node<E> begin;
    private Node<E> end;
    private int size;

    public LinkedList() {
        begin = new Node<>();
        end = new Node<>();
        begin.next = end;
        end.prev = begin;
        size = 0;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}            
        else if (index == size) {addLast(item);}
        else if (index == 0) {addFirst(item);}
        else {
            Node<E> obj = begin.next;
            for (int i = 0; i < index; i++)
                obj = obj.next;
            Node<E> add = new Node<>(obj.prev, item, obj);
            obj.prev.next = add;
            obj.prev = add;
            size++;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();} 
        else if (index == size) {addLast(item);} 
        else {
            Node<E> obj = begin.next;
            for (int i = 0; i < index; i++)
                obj = obj.next;
            obj.item = item;
        }
    }

    @Override
    public E get (int index) {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        Node<E> obj = begin.next;
        int i = 0;
        while(i < index){
            obj = obj.next;
            i++;
        }
        return obj.item;
    }

    @Override
    public int indexOf(E item) {
        Node<E> obj = begin.next;
        int i = 0;
        while (i < size){
            if (obj.item == item) {return i;}
            obj = obj.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        int i = size - 1;
        Node<E> obj = end.prev;
        while (i >= 0) {
            if (obj.item == item) {return i;}
            obj = obj.prev;
            i--;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {throw new NoSuchElementException();}
        else {
            E res = null;
            Node<E> obj = begin.next;
            for (int i = 0; i < index; i++)
                obj = obj.next;
            res = deleteElement(obj);
            return res;
        }
    }

    private E deleteElement(Node<E> node) {
        E res = null;
        if (node.next != null && node.prev != null) {
            res = node.item;
            node.next.prev = node.prev;
            node.prev.next = node.next;
        } else if (node.next == null) {
            res = node.item;
            end.prev = node.prev;
            node.prev.next = end;
        } else if (node.prev == null) {
            res = node.item;
            begin.next = node.next;
            node.next.prev = begin;
        }
        size--;
        return res;
    }

    @Override
    public LinkedList<E> subList(int from, int to) {
        if (to >= size || from > to || from < 0 || to < 0) {throw new IndexOutOfBoundsException();}
        LinkedList<E> newList = new LinkedList<>();
        Node<E> obj = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {newList.addLast(obj.item);}
            obj = obj.next;
        }
        return newList;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {return true;}
        return false;
    }

    @Override
    public boolean contains(E item) {
        Node<E> obj = begin.next;
        while (obj.item != item) {
            if (obj.next == null) {return false;}
            obj = obj.next;
        }
        return true;
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(E item) {
        boolean isDelete = false;
        Node<E> obj = begin.next;
        while (obj != null) {
            if (obj.item == item) {
                deleteElement(obj);
                isDelete = true;
            }
            obj = obj.next;
        }
        return isDelete;
    }

    @Override
    public void clear() {
        Node<E> obj = begin.next;
        while (obj.next != null) {
            deleteElement(obj);
            obj = obj.next;
        }
    }

    @Override
    public void addFirst(E item) {
        if (begin.next.equals(end)) {
            Node<E> el = new Node<>(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node<E> el = new Node<>(null, item, begin.next);
            begin.next.prev = el;
            begin.next = el;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        if (end.prev.equals(begin)) {
            Node<E> el = new Node<>(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node<E> el = new Node<>(end.prev, item, null);
            end.prev.next = el;
            end.prev = el;
        }
        size++;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0) {throw new NoSuchElementException();}
        return begin.next.item;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size == 0) {throw new NoSuchElementException();}
        return end.prev.item;
    }

    @Override
    public E pollFirst() {
        if (size == 0) { return null;} 
        else {
            E el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public E pollLast() {
        if (size == 0) {return null;} 
        else {
            E el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) {throw new NoSuchElementException();}
        else {
            E el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0) {throw new NoSuchElementException();} 
        else {
            E el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }
}