import java.util.Iterator;

public class iteradorbase<T> implements Iterator<T> {

    private nodo<T> cursor;

    

    public iteradorbase(nodo<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T info = cursor.getCont();
        cursor = cursor.getNext();
        return info;
    }

    
}
