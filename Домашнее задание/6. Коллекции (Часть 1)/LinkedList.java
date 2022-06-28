import java.util.*;

public class LinkedList implements List, Deque {

    private Node begin;
    private Node end;
    private int size;

    public LinkedList() {
        begin = new Node();
        end = new Node();
        begin.next = end;
        end.prev = begin;
        size = 0;
    }

    @Override
    public void add(int index, Object item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();} 
        else if (index == size) {addLast(item);} 
        else if (index == 0) {addFirst(item);} 
        else {
            Node obj = begin.next;
            for (int i = 0; i < index; i++) 
                obj = obj.next;
            Node add = new Node(obj.prev, item, obj);
            obj.prev.next = add;
            obj.prev = add;
            size++;
        }
    }

    @Override
    public void set(int index, Object item) throws IndexOutOfBoundsException {
        if (index > size || index < 0) {throw new NoSuchElementException();} 
        else if (index == size) {addLast(item);} 
        else if (index < (int) size / 2) {
            Node buff = begin.next;
            for (int i = 0; i < index; i++)
                buff = buff.next;
            buff.item = item;
        } else {
            Node buff = end.prev;
            for (int i = size; i > index + 1; i--)
                buff = buff.prev;
            buff.item = item;
        }
    }

    @Override
    public Object get (int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        Node obj = begin.next;
        int i = 0;
        while(i < index){
            obj = obj.next;
            i++;
        }
        return obj.item;
    }

    @Override
    public int indexOf(Object item) {
        Node obj = begin.next;
        int i = 0;
        while (i < size){
            if (obj.item == item) {return i;}
            obj = obj.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        int i = size - 1;
        Node buff = end.prev;
        while (i >= 0) {
            if (buff.item == item) {return i;}
            buff = buff.prev;
            i--;
        }
        return -1;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {throw new NoSuchElementException();}
        else {
            Object res = null;
            Node buff = begin.next;
            for (int i = 0; i < index; i++)
                buff = buff.next;
            res = deleteElement(buff);
            return res;
        }
    }

    @Override
    public LinkedList subList(int from, int to) throws IndexOutOfBoundsException {
        if (to >= size || from > to || from < 0 || to < 0) {throw new IndexOutOfBoundsException();}
        LinkedList newList = new LinkedList();
        Node buff = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {newList.addLast(buff.item);}
            buff = buff.next;
        }
        return (LinkedList) newList;
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
    public boolean contains(Object item) {
        Node buff = begin.next;
        while (buff.item != item) {
            if (buff.next == null) {return false;}
            buff = buff.next;
        }
        return true;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        boolean isDelete = false;
        Node buff = begin.next;
        while (buff != null) {
            if (buff.item == item) {
                deleteElement(buff);
                isDelete = true;
            }
            buff = buff.next;
        }
        return isDelete;
    }

    @Override
    public void clear() {
        Node buff = begin.next;
        while (buff.next != null) {
            deleteElement(buff);
            buff = buff.next;
        }
    }

    @Override
    public void addFirst(Object item) {
        if (begin.next.equals(end)) {
            Node el = new Node(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node el = new Node(null, item, begin.next);
            begin.next.prev = el;
            begin.next = el;
        }
        size++;
    }

    @Override
    public void addLast(Object item) {
        if (end.prev.equals(begin)) {
            Node el = new Node(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node el = new Node(end.prev, item, null);
            end.prev.next = el;
            end.prev = el;
        }
        size++;
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        if (size == 0) {throw new NoSuchElementException();}
        return begin.next.item;
    }

    @Override
    public Object getLast() throws NoSuchElementException {
        if (size == 0) {throw new NoSuchElementException();}
        return end.prev.item;
    }

    @Override
    public Object pollFirst() {
        if (size == 0) { return null;} 
        else {
            Object el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public Object pollLast() {
        if (size == 0) {return null;} 
        else {
            Object el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public Object removeFirst() {
        if (size == 0) {throw new NoSuchElementException();}
        else {
            Object el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public Object removeLast() {
        if (size == 0) {throw new NoSuchElementException();} 
        else {
            Object el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    private Object deleteElement(Node node) {
        Object res = null;
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
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }
}