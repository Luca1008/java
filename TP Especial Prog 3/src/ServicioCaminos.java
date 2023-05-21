import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		// Resolver Caminos
        HashSet<Integer> visitados = new HashSet<>();
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		caminos.add(this.dfs(this.origen, visitados, 0));
		return  caminos;
	}

	private List<Integer> dfs ( Integer origen, HashSet<Integer> visitados, int cont){
        List<Integer> aux = new ArrayList<>(origen);
        visitados.add(origen);
        Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
        if( edge != null){
            while ((edge.hasNext())&&(cont <= lim)&&(origen!=destino)){
                Integer n = edge.next();
                if(!visitados.contains(n)){
                    aux.addAll(this.dfs(n, visitados,++cont));
                }
            }
        }
        return aux;
    }

}