import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> {
    private List<E> array;
    private int index;

    public ListIterator(List<E> arr) {
        this.array = arr;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {throw new NoSuchElementException();}
        index++;
        return(array.get(index - 1));        
    }
}