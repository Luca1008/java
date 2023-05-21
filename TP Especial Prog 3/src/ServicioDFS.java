import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Iterator;


public class ServicioDFS {

	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		// Resolver DFS
        // Crear un vector de vertices
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        List<Integer> verticesList = new ArrayList<Integer>();
        HashSet<Integer> visitados = new HashSet<>();
        while (vertices.hasNext()){
            Integer n = vertices.next();
            if(!visitados.contains(n)){
                verticesList.addAll(this.dfs(n, visitados));
            }
        }
		return verticesList;
	}

    public List<Integer> dfs ( Integer origen, HashSet<Integer> visitados){
        List<Integer> aux = new ArrayList<>(origen);
        visitados.add(origen);
        Iterator<Integer> edge = this.grafo.obtenerAdyacentes(origen);
        if( edge != null){
            while (edge.hasNext()){
                Integer n = edge.next();
                if(!visitados.contains(n)){
                    aux.addAll(this.dfs(n, visitados));
                }
            }
        }
        return aux;
    }



/* void dfs_forest(list<int> & orden_dfs)const{
		set<int> visitados;
        for(typename set<Vertice<C>>::const_iterator it_vertices = coleccion.begin(); it_vertices != coleccion.end(); ++it_vertices){
            if(visitados.find(it_vertices->getVertice()) == visitados.end())
                dfs(it_vertices->getVertice(), visitados, orden_dfs);
        }
	}


private:
	/*
	 * Definir la estructura interna
	 */

	// void dfs(int origen, set<int> & visitados, list<int> & orden_dfs)const{
	// 	orden_dfs.push_front((orden_dfs.empty())? -1 : origen);
	// 	visitados.insert(origen);
    //     typename set<Vertice<C>>::const_iterator it_vertices = coleccion.find(origen);
    //     for(typename set<Arco<C>>::const_iterator it_arcos = it_vertices->getArcos().begin(); it_arcos != it_vertices->getArcos().end(); ++it_arcos)
    //         if(visitados.find(it_arcos->getAdyacente()) == visitados.end())
    //             dfs(it_arcos->getAdyacente(), visitados, orden_dfs);
	// } 
    // */

	/* private HashMap<String, Archivo> archivos;

    public ServicioDFS() {
        this.archivos = new HashMap<>();
    }

    public void agregarArchivo(Archivo archivo) {
        this.archivos.put(archivo.getNombre(), archivo);
    }

    public void eliminarArchivo(String nombre) {
        this.archivos.remove(nombre);
    }

    public Archivo buscarArchivo(String nombre) {
        return this.archivos.get(nombre);
    }

    public void actualizarArchivo(Archivo archivo) {
        this.archivos.put(archivo.getNombre(), archivo);
    }

    public void recorrerArchivos() {
        for (Map.Entry<String, Archivo> entry : this.archivos.entrySet()) {
            String nombre = entry.getKey();
            Archivo archivo = entry.getValue();
            // Realizar operaciones en el archivo
        }
    } */
}
