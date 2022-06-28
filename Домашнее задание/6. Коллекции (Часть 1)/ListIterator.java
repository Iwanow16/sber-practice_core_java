import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator implements Iterator<Object> {
    private List array;
    private int index;

    public ListIterator(List arr) {
        this.array = arr;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.size();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {throw new NoSuchElementException();}
        index++;
        return(array.get(index - 1));        
    }
}