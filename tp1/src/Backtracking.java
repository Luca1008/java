import java.util.ArrayList;

public class Backtracking {
    private ArrayList<Integer> conjunto;
    private ArrayList<ArrayList<Integer>> resultados;
    private int res;

    public Backtracking(ArrayList<Integer> conjunto, int res) {
        this.conjunto = conjunto;
        this.resultados = new ArrayList<>();
        this.res = res;
    }

    public ArrayList<ArrayList<Integer>> bt(){
        bt(0, conjunto, new ArrayList<Integer>());
        return resultados;
    }

    private void bt(int suma, ArrayList<Integer> conjunto, ArrayList<Integer> actual){

        if (conjunto.size() == 0) {
            if (suma == res) 
                resultados.add(new ArrayList<>(actual));
            return;
        }

        // primer cambio
        int n = conjunto.remove(0);

        // rama en la que no agrego el valor
        bt(suma, conjunto, actual);

        // poda
        if (!poda(suma)){
            // continuo cambios
            actual.add(n);
            suma += n;

            // rama en la que agrego el valor
            bt(suma, conjunto, actual);

            // deshago cambios
            suma -= n;
            actual.remove(Integer.valueOf(n));
        };

        // deshago primer cambio
        conjunto.add(0, n);
    }

    private boolean poda(int suma){
        return suma == res;
    }
}
