import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        comparadorNumero comparoNodoNum = new comparadorNumero();
    
        listavinculada<Integer> MyLista = new listavinculada<Integer>(comparoNodoNum);
        MyLista.insertFront(4);
        MyLista.insertFront(2);
        MyLista.insertFront(1);

        

        


        
        listavinculada<Integer> MyLista2 = new listavinculada<Integer>(comparoNodoNum);
        MyLista2.insertFront(4);
        MyLista2.insertFront(5);
        MyLista2.insertFront(6);

    for (Integer integer : MyLista) {
            System.out.println(integer);
         }
     for (Integer integer : MyLista2) {
        System.out.println(integer);
     }

     
     System.out.println("Hello, World!");
     MyLista.insertarOrdenado(3);
     for (Integer integer : MyLista) {
        System.out.println(integer);
     }
     System.out.println("Hello, World!");
     MyLista.insertarOrdenado(32);
     for (Integer integer : MyLista) {
        System.out.println(integer);
     }
     System.out.println("Hello, World!");
     MyLista.insertarOrdenado(0);
     
     for (Integer integer : MyLista) {
        System.out.println(integer);
     }
     
    
     
        

    }
}
