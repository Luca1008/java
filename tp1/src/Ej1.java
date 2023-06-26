package parcial_2022;

import java.util.ArrayList;

public class Ej1 {
    private Grafo grafo;
    private int X;
    private boolean sigo;
    private boolean cumple;


    public void bt(int origen, ArrayList<Integer> camino){

        Vertice v = grafo.get(origen);

        if (v.getColor() == "yellow") {
            camino.add(origen); // 2-4-3-5-4
            calcSuma(camino, origen);
            return;
        }

        camino.add(origen); // 2-4-3-5

        v.setColor("yellow");

        ArrayList<Arco> arcos = v.getArcos();

        for (Arco a : arcos) {
            int idDestino = a.getDestino();

            bt(idDestino);
        }

        camino.remove(origen);
        v.setColor("white");
    }


    private void calcSuma(ArrayList<Integer> lista, int idInicioCiclo){
        int suma = 0;
        int i = 0;
        while (lista.get(i) != idInicioCiclo) {
            lista.remove(i); // quito los numeros previos a haber encontrado el ciclo;
            i++;
        }

        i = 0;
        while (i<lista.size()-1) { // en la ultima posicion no pido ady ya que completa el ciclo
            int tmpId = lista.get(i);
            int nextId = lista.get(i++);

            Vertice v = grafo.get(tmpId);
            Arco a = v.getAdyacente(nextId);
            suma+= a.getPeso();
            i++;
        }
    }


}
