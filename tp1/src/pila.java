public class pila<T> {
    private listavinculada<T> tareas;

    public pila(listavinculada<T> tareas) {
        this.tareas = tareas;
    }

    public void push(nodo<T> x){
        tareas.setFirst(x);
    }

    public T pop(){
        T temp = tareas.extractFront();
        return temp;
    }

    public T top(){
        T temp =  tareas.getFirst().getCont();
        return temp;
    }
    
    public void reverse(){
        tareas.invertir();
    }
}
