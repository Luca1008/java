
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class ServicioBFS {

	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	

	public List<Integer> bfsForest() {
		// Resolver BFS
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		List<Integer> bfsList = new ArrayList<Integer>();
		Set<Integer> visitados = new HashSet<Integer>();
		while (vertices.hasNext()){
		  Integer n = vertices.next();
		  if(!visitados.contains(n)){
			bfsList.addAll(this.bfs(n, visitados));
		  }
		}
		return bfsList;
	  }

	  private List<Integer> bfs (Integer origen, Set<Integer> visited){
		List<Integer> bfsList = new ArrayList<Integer>();
		visited.add(origen);
		Queue<Integer> fila = new LinkedList<Integer>();
		fila.add(origen);
		while(!fila.isEmpty()){
		  int n = fila.poll();
		  bfsList.add(n);
		  Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(n);
		  while (adyacentes.hasNext()){
			Integer a = adyacentes.next();
			if(!visited.contains(a)){
			  fila.add(a);
			  visited.add(a);
			}
		  }
		}
		
		return bfsList;
	  }
	  
	  
	  /* private List<Integer> bfs (Integer origen, Set<Integer> visited){
		List<Integer> bfsList = new ArrayList<Integer>();
		visited.add(origen);
		List<Integer> fila = new ArrayList<Integer>();
		fila.add(origen);
		while(!fila.isEmpty()){
		  int n = fila.remove(0);
		  bfsList.add(n);
		  Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(n);
		  while (adyacentes.hasNext()){
			Integer a = adyacentes.next();
			if(!visited.contains(a)){
			  fila.add(a);
			}
		  }
		}
		
		return bfsList;
	  } */
	  

	/* public List<Integer> bfsForest() {
		// Resolver BFS
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		List<Integer> bfsList = new ArrayList<Integer>();
		HashSet<Integer> visitados = new HashSet<Integer>();
		while (vertices.hasNext()){
            Integer n = vertices.next();
            if(!visitados.contains(n)){
                bfsList.addAll(this.bfs(n, visitados));
            }
        }
		return bfsList;
	}

	private List<Integer> bfs (Integer origen, HashSet<Integer> visited){
		List<Integer> bfsList = new ArrayList<Integer>();
		visited.add(origen);
		List<Integer> fila = new ArrayList<Integer>();
		fila.add(0, origen);
		while(!fila.isEmpty()){
			int n = fila.get(0);
			fila.remove(0);
			bfsList.add(0, n);
			Iterator<Integer> vertices = this.grafo.obtenerAdyacentes(n);
			while (vertices.hasNext()){
				Integer a = vertices.next();
					if(!visited.contains(a)){
						fila.add(fila.size(), a);
					}
				}
			}
		
		return bfsList;
	} */
}
