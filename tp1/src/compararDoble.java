


import java.util.Comparator;

public class compararDoble<T> implements Comparator<T>{
    private Comparator<T> a1, a2;
    

    public compararDoble(Comparator<T> a1, Comparator<T> a2) {
        this.a1 = a1;
        this.a2 = a2;
    }


    @Override
    public int compare(T o1, T o2) {
        int aux = a1.compare(o1, o2);
        if(aux == 0){
            return a2.compare(o1, o2);
        }
        else{
            return aux;
        }
    }
}
