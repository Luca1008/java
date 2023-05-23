import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("NUEVO MODULO");

        GrafoDirigido<Integer> mapa = new GrafoDirigido<>();

        mapa.agregarVertice(0);
        mapa.agregarVertice(1);

        mapa.agregarVertice(2);

        mapa.agregarVertice(3);

        mapa.agregarVertice(6);

        mapa.agregarVertice(7);

        mapa.agregarVertice(23);

        mapa.agregarVertice(43);

        mapa.agregarVertice(89);

        mapa.agregarVertice(100);
        mapa.agregarArco(0, 100, null);
        mapa.agregarArco(100, 43, null);



        mapa.agregarArco(0, 1, null);
        mapa.agregarArco(0, 43, null);
        mapa.agregarArco(1, 2, null);
        mapa.agregarArco(2, 3, null);
        mapa.agregarArco(2, 7, null);
        mapa.agregarArco(2, 6, null);
        mapa.agregarArco(3, 7, null);
        mapa.agregarArco(6, 7, null);
        mapa.agregarArco(7, 23, null);
        mapa.agregarArco(23, 1, null);
        mapa.agregarArco(23, 2, null);
        mapa.agregarArco(23, 43, null);
        mapa.agregarArco(43, 89, null);
        mapa.agregarArco(43, 23, null);
        mapa.agregarArco(89, 23, null);

        mapa.toString();

        mapa.borrarVertice(100);
        mapa.borrarArco(0, 100);

        /* System.out.println("Borre");
        mapa.toString();

        System.out.println(mapa.contieneVertice(23));
        System.out.println(mapa.contieneVertice(67));

        System.out.println(mapa.existeArco(23, 3));
        System.out.println(mapa.existeArco(23, 2));

        System.out.println(mapa.obtenerArco(43, 89));
        System.out.println(mapa.cantidadVertices());

        System.out.println("separacion 1 ");

        Iterator<Integer> iter = mapa.obtenerVertices();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("separacion 2 ");

        Iterator<Integer> iter2 = mapa.obtenerAdyacentes(23);
        while (iter2.hasNext()){
            System.out.println(iter2.next());
        }
        System.out.println("separacion 3 ");

        Iterator<Arco<Integer>> iter3 = mapa.obtenerArcos();
        while (iter3.hasNext()){
            System.out.println(iter3.next());
        } */
        System.out.println("separacion 4");

        Iterator<Arco<Integer>> arcoIterator = mapa.obtenerArcos(23);
        while (arcoIterator.hasNext()){
            System.out.println(arcoIterator.next());
        }

        System.out.println("separacion 5");

        ServicioDFS gDfs = new ServicioDFS(mapa);
        List<Integer> resultado = gDfs.dfsForest();
        System.out.println(resultado.toString());


        System.out.println("separacion 6");

        ServicioBFS gBfs = new ServicioBFS(mapa);
        List<Integer> resultados = gBfs.bfsForest();
        System.out.println(resultados.toString());

        System.out.println("separacion 7");

        ServicioCaminos caminito = new ServicioCaminos(mapa, 0, 43, 4);

        List<List<Integer>> resList = caminito.caminos();
        for (List<Integer> listaInterna : resList) {
            System.out.println(listaInterna.toString());
        }
        
        



    }
}
