import java.util.Comparator;
import java.util.Iterator;

public class listavinculada<T> implements Iterable<T> {
    private nodo<T> first;
    private int size;
    private Comparator<T> Comp;
    

    public listavinculada(nodo<T> first, Comparator<T> comp) {
        this.first = first;
        this.size = 1;
        this.Comp= comp;
    }

    public listavinculada(Comparator<T> comp) {
        this.first = null;
        this.size = 0;
        this.Comp= comp;
    }

    public nodo<T> getFirst() {
        return first;
    }


    public void setFirst(nodo<T> first) {
        first.setNext(this.first);
        this.first = first;
        size= size+1;
    }
    public void insertFront(T cont){
        nodo<T> tmp = new nodo<T>(cont, null);
        tmp.setNext(this.first);
        this.first=tmp;
        size= size+1;
    }

    public int getSize(){
        return this.size;
    }

    public T extractFront() {		
        nodo<T> tmp = first.getNext();
        T temp = first.getCont();
        this.first = tmp;
        size= size-1;
		return temp;
	}

	public boolean isEmpty() {
		if(first == null){
            return true;
        }
        else{
		    return false;
        }
	}
	
	public T get(int index) {
        if((index < this.size)&&(-1>index)){
            nodo<T> tmp = first;
            for(int i = 0; i <= index; i++){
                if(i == index){
                    return tmp.getCont();
                }
                tmp = tmp.getNext();
            }
        }
		
		return null;
	}
	
	@Override
	public String toString() {
        nodo<T> tmp = first;
        for( int i = 0; i <= size; i++){
            tmp.toString();
            tmp = tmp.getNext();
        }
        return null;
	}

    public void invertir(){
        nodo<T> cabeza = first;
        nodo<T> anterior = null;
        nodo<T> tmp = null;

        while(cabeza != null){
            tmp =  cabeza.getNext();
            cabeza.setNext(anterior);
            anterior = cabeza;
            cabeza = tmp;
        }
        this.first =  anterior;
    }

     public int indexOf(T info){
        if(isEmpty()){
            nodo<T> tmp = first;
            for( int i = 0; i <= size; i++){
                T cont = tmp.getCont();
                if(cont.equals(info)){
                    return i;
                }
                tmp = tmp.getNext();
            }
        }
        return -1;
    } 

    @Override
    public Iterator<T> iterator() {
        return new iteradorbase<T>(this.first);
    }


    public void insertarOrdenado(T nod){
        nodo<T> tmp = new nodo<T>(nod, null);
        int cont = 0;
        nodo<T> aux = this.first;
        nodo<T> auxSig = this.first.getNext();
        boolean inserto = false;
        if(this.Comp.compare(nod, first.getCont()) == -1){
            this.insertFront(nod);
            inserto = true;
        }
        
        while((cont < this.size)&&(!inserto)&&(auxSig!=null)){
            if(this.Comp.compare(nod, auxSig.getCont()) == -1){
                aux.setNext(tmp);
                tmp.setNext(auxSig);
                inserto = true;
                size= size+1;
            }


            else if(this.Comp.compare(nod, auxSig.getCont()) == 0){
                inserto = true;
            }
            else{
                aux = auxSig;
                auxSig = auxSig.getNext();
                cont++;
            }

        }
        if (auxSig==null) {
            aux.setNext(tmp);
        }

        // if(cont == size){
        //     auxSig.setNext(tmp);
        // }
        
    }





}

//para en un  array agregar al principio  tenes q realizar todo  un corrimiento  osea un O(n) en cambio aca no, buscar un elemento en un array tambien
// es un On como aca tenes q recorrer todos los elementos a no ser q se use el metodo de agarrar una mitad pero ppara esos los elementos tienen q estar ordenados
// y para determinar la cantidad tambien es un O(n)


//
