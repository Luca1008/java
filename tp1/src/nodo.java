public class nodo<T> {
    private T cont;
    private nodo<T> next;
    
    public nodo(T cont, nodo<T> next) {
        this.cont = cont;
        this.next = next;
    }

    public T getCont() {
        return cont;
    }

    public void setCont(T cont) {
        this.cont = cont;
    }

    public nodo<T> getNext() {
        return next;
    }

    public void setNext(nodo<T> next) {
        this.next = next;
    }

    public String toString(){
        return " "+ cont;
    }
}
