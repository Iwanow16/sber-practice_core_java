import java.util.Iterator;

public class ArrayList implements List {

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
    public ArrayList(ArrayList arrayList) {
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
    public void add(int index, Object item) throws IndexOutOfBoundsException {
        if (size == capacity) {arrayList = addCapacity();}
        if(index < 0 || index > size) {throw new IndexOutOfBoundsException();}
        else {
            for(int i = size; i > index; i--) {arrayList[i] = arrayList[i - 1];}
            arrayList[index] = item;
            size++;
        }
    }

    @Override
    public void set(int index, Object item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}
        else if (index == size) {add(item);}
        else {arrayList[index] = item;}
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        return arrayList[index];
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++)
            if (arrayList[i].equals(item)) {return i;}
        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--)
            if (arrayList[i].equals(item)) {return i;}
        return -1;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}
        Object removeElement = arrayList[index];
        for (int i = index; i < size; i++) arrayList[i] = arrayList[i + 1];
        size--;
        return removeElement;
    }

    @Override
    public ArrayList subList(int from, int to) throws IndexOutOfBoundsException {
        if (from < 0 || to < 0 || to > size || from > to) {throw new IndexOutOfBoundsException();}
        ArrayList subArrayList = new ArrayList();
        for (int i = from; i < to; i++) subArrayList.add(arrayList[i]);
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
    public boolean contains(Object item){
        for (Object object : arrayList)
            if (item.equals(object)) {return true;}
        return false;
    }

    @Override
    public boolean add(Object item){
        if (size < capacity) {arrayList[size] = item;}
        else {
            Object[] newArrayList = addCapacity();
            newArrayList[size] = item;
            arrayList = newArrayList;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object item)
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
    public Iterator<Object> iterator() {
        return new ListIterator(this);
    }
    
    private Object[] addCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] newArrayList = new Object[capacity];
        for (int i = 0; i < size; i++) 
            newArrayList[i] = arrayList[i];
        return newArrayList;
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