import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private Object[] arrayList;
    private int capacity;
    private int size;

    // Cоздает пустой списочный массив объемом в 10 элементов
    public ArrayList() {
        this.capacity = 10;
        this.arrayList = new Object[capacity];
        this.size = 0;
    }

    // Cоздает списочный массив, инициализируемый элементами из переданной коллекции
    public ArrayList(ArrayList<E> arrayList) {
        this.arrayList = arrayList.getArrayList();
        this.capacity = arrayList.getCapacity();
        this.size = arrayList.getSize();
    }
    
    // Cоздает списочный массив, имеющий начальную емкость
    public ArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        this.arrayList = new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public void add(int index, E item) throws IndexOutOfBoundsException {
        if (size == capacity) {arrayList = addCapacity();}
        if(index < 0 || index > size) {throw new IndexOutOfBoundsException();}
        else {
            for(int i = size; i > index; i--) {arrayList[i] = arrayList[i - 1];}
            arrayList[index] = item;
            size++;
        }
    }

    @Override
    public void set(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}
        else if (index == size) {add(item);}
        else {arrayList[index] = item;}
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        return (E) arrayList[index];
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++)
            if (arrayList[i].equals(item)) {return i;}
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        for (int i = size - 1; i >= 0; i--)
            if (arrayList[i].equals(item)) {return i;}
        return -1;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        E removeElement = (E) arrayList[index];
        for (int i = index; i < size; i++) 
            arrayList[i] = arrayList[i + 1];
        size--;
        return removeElement;
    }

    @Override
    public ArrayList<E> subList(int from, int to) throws IndexOutOfBoundsException {
        if (from < 0 || to < 0 || to > size || from > to) {throw new IndexOutOfBoundsException();}
        ArrayList<E> subArrayList = new ArrayList<>();
        for (int i = from; i < to; i++) subArrayList.add((E) arrayList[i]);
        return subArrayList;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if (size == 0) {return true;}
        return false;
    }

    @Override
    public boolean contains(E item){
        for (Object object : arrayList)
            if (item.equals(object)) {return true;}
        return false;
    }

    @Override
    public boolean add(E item){
        if (size < capacity) {arrayList[size] = item;}
        else {
            Object[] newArrayList = addCapacity();
            newArrayList[size] = item;
            arrayList = newArrayList;
        }
        size++;
        return true;
    }

    private Object[] addCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] newArrayList = new Object[capacity];
        for (int i = 0; i < size; i++) 
            newArrayList[i] = arrayList[i];
        return newArrayList;
    }

    @Override
    public boolean remove(E item)
    {
        int arrSize = size;
        while(contains(item)) remove(indexOf(item));
        return arrSize != size;
    }

    @Override
    public void clear(){
        capacity = 10;
        arrayList = new Object[capacity];
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }

    public Object[] getArrayList() {
        return arrayList;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
