import java.util.ArrayList;
import java.util.Collections;
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
		List<Integer> recorrido = new ArrayList<Integer>(); // lista para guardar el recorrido
		boolean llegamos = false;
		this.dfs(this.origen, visitados, 0, llegamos, caminos, recorrido);
		System.out.println("El recorrido completo es: " + recorrido.toString()); // imprimir el recorrido
		return caminos;
	  }
	  
	  private void dfs (Integer origen, HashSet<Integer> visitados, int cont, boolean llegamos, List<List<Integer>> caminos, List<Integer> recorrido){
		List<Integer> aux = new ArrayList<>(Collections.singletonList(origen));
		visitados.add(origen);
		recorrido.add(origen); // agregar el vértice visitado al recorrido
		if (origen == this.destino) {
		  llegamos = true;
		  caminos.add(aux); // agregar el camino encontrado a la lista de caminos
		  return;
		}
		Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
		if (edge != null) {
		  while (edge.hasNext() && cont < this.lim && !llegamos){
			Integer n = edge.next();
			if(!visitados.contains(n)){
			  this.dfs(n, visitados, cont + 1 ,llegamos, caminos, recorrido); // incrementar cont por cada arco
			  visitados.remove(n); // quitar el vértice visitado para explorar otros caminos
			}
		  }
		}
	  }
	  

/* 	public List<List<Integer>> caminos() {
		// Resolver Caminos
		HashSet<Integer> visitados = new HashSet<>();
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		boolean llegamos = false;
		this.dfs(this.origen, visitados, 0, llegamos, caminos);
		return caminos;
	  }
	  
	  private void dfs (Integer origen, HashSet<Integer> visitados, int cont, boolean llegamos, List<List<Integer>> caminos){
		List<Integer> aux = new ArrayList<>(Collections.singletonList(origen));
		visitados.add(origen);
		System.out.println("Visitando el vértice " + origen); // imprimir el vértice visitado
		if (origen == this.destino) {
		  llegamos = true;
		  caminos.add(aux); // agregar el camino encontrado a la lista de caminos
		  return;
		}
		Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
		if (edge != null) {
		  while (edge.hasNext() && cont < this.lim && !llegamos){
			Integer n = edge.next();
			if(!visitados.contains(n)){
			  this.dfs(n, visitados, cont + 1 ,llegamos, caminos); // incrementar cont por cada arco
			  visitados.remove(n); // quitar el vértice visitado para explorar otros caminos
			}
		  }
		}
	  } */
	   
	 
	  /* private void dfs (Integer origen, HashSet<Integer> visitados, int cont, boolean llegamos, List<List<Integer>> caminos){
		List<Integer> aux = new ArrayList<>(Collections.singletonList(origen));
		visitados.add(origen);
		if (origen == this.destino) {
		  llegamos = true;
		  caminos.add(aux); // agregar el camino encontrado a la lista de caminos
		  return;
		}
		Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
		if (edge != null) {
		  while (edge.hasNext() && cont < this.lim && !llegamos){
			Integer n = edge.next();
			if(!visitados.contains(n)){
			  this.dfs(n, visitados, cont + 1 ,llegamos, caminos); // incrementar cont por cada arco
			  visitados.remove(n); // quitar el vértice visitado para explorar otros caminos
			}
		  }
		}
	  } */
	  
	
	/* public List<List<Integer>> caminos() {
		// Resolver Caminos
        HashSet<Integer> visitados = new HashSet<>();
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		Iterator<Integer> edge = this.grafo.obtenerAdyacentes(this.origen);
		boolean llegamos = false;
		if (edge != null){
			while(edge.hasNext()){
				caminos.add(this.dfs(this.origen, visitados, 0,llegamos));
			}
		}
		
		return  caminos;
	}

	private List<Integer> dfs ( Integer origen, HashSet<Integer> visitados, int cont, boolean llegamos){
        List<Integer> aux = new ArrayList<>(origen);
        visitados.add(origen);
        Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
        if( edge != null){
            while ((edge.hasNext())&&(cont < lim)&&(!llegamos)){
                Integer n = edge.next();
				if(origen == this.destino){
					llegamos = true;
				}
                if(!visitados.contains(n)){
					List<Integer> control = new ArrayList<>(this.dfs(n, visitados,++cont,llegamos));
					if(llegamos){
						aux.addAll(control);
						return aux;
					}
                    
                }
            }
        }
        return null;
    } */

}