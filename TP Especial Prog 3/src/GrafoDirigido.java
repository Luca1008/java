import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {

    protected HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;

    public GrafoDirigido() {
        vertices = new HashMap<>();
    }

    /*
     * La complejidad de la función 'agregarVertice' es O(1) en el mejor de los
     * casos y O(n) en el peor de los casos.
     * En el mejor de los casos, la función simplemente comprueba si el vértice ya
     * existe en el HashMap y devuelve sin hacer nada más.
     * Esto tiene una complejidad de tiempo constante O(1).
     * En el peor de los casos, la función debe agregar un nuevo vértice al HashMap.
     * Esto implica crear un nuevo objeto HashMap y agregarlo al HashMap principal.
     * La complejidad de esto es O(n), donde n es el número de elementos en el
     * HashMap.
     */
    public void agregarVertice(int verticeId) {
        // controlo que el vertice no exista
        if (!this.contieneVertice(verticeId)) {
            // agrego el vertice
            vertices.put(verticeId, new HashMap<>());
        }
    }

    /*
     * La complejidad de la función ‘borrarVertice’ es O(1) en el mejor de los casos
     * y O(n) en el peor de los casos.
     * En el mejor de los casos, la función simplemente elimina un elemento del
     * HashMap y devuelve sin hacer nada más.
     * Esto tiene una complejidad de tiempo constante O(1).
     * En el peor de los casos, la función debe eliminar un elemento del HashMap
     * y luego recorrer todo el HashMap para eliminar cualquier referencia a ese
     * elemento(Osea sus arcos).
     * La complejidad de esto es O(n), donde n es el número de elementos en el
     * HashMap.
     */

    @Override
    public void borrarVertice(int verticeB) {
        // borro vertice
        vertices.remove(verticeB);
        // for (int verticeId : this.vertices.keySet()) {
        //     for (int destinoId : this.vertices.get(verticeId).keySet()) {
        //         if (verticeB == destinoId) {
        //             // borro arco
        //             this.vertices.get(verticeId).remove(destinoId);
        //             System.out.println("True");
        
        //         };
        //     }
        // }
        
        // al borrar vertice tendria q borrar todos los arcos q apuntan a el vertice borrado pero no nos sale
        //se nos rompe y no sabemos por q 
    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace get, donde obtiene el vertice origen (O(1)) y
     * put, donde coloca el arco al vertice obtenido(O(1))
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public void agregarArco(int verticeOrigen, int verticeDestino, T etiqueta) {
        // controlo que el vertice no exista
        if (this.contieneVertice(verticeOrigen)) {
            // Creamos un arco con los datos ingresados
            Arco<T> auxArco = new Arco<>(verticeOrigen, verticeDestino, etiqueta);
            // Buscamos el vertice y agregamos el arco
            vertices.get(verticeOrigen).put(verticeDestino, auxArco);
        }

    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace get, donde obtiene el vertice origen (O(1)) y
     * remove, donde elimina el arco que se encuentre entre el vertice origen y
     * destino.
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public void borrarArco(int verticeOrigen, int verticeDestino) {
        // Buscamos el arco y lo borramos
        vertices.get(verticeOrigen).remove(verticeDestino);

    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace get, donde obtiene el vertice origen (O(1)) y
     * containsKey, que no recorre "vertices", sino que utiliza una función hash
     * para calcular el índice en la tabla donde se almacenaría el elemento con esa
     * clave.
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public boolean contieneVertice(int verticeId) {
        // Buscamos el vertice y devuelve si existe
        boolean contains = vertices.containsKey(verticeId);
        return contains;
    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace get, donde obtiene el vertice origen (O(1)) y
     * containsKey, que no recorre "vertices", sino que utiliza una función hash
     * para calcular el índice en la tabla donde se almacenaría el elemento con esa
     * clave.
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public boolean existeArco(int verticeOrigen, int verticeDestino) {
        // Buscamos el arco y devuelve si existe
        if (vertices.containsKey(verticeOrigen)) {
            if (vertices.get(verticeOrigen).containsKey(verticeDestino)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace get, donde obtiene el vertice origen y el
     * vertice destino del arco para obtenerlo (O(1))
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public Arco<T> obtenerArco(int verticeOrigen, int verticeDestino) {
        Arco<T> aux = vertices.get(verticeOrigen).get(verticeDestino);
        return aux;
    }

    @Override
    /*
     * COMPLEJIDAD: O(1) Porque hace size, donde obtiene los numeros de elementos
     * que obtiene el Hash
     * Por lo tanto, el tiempo no aumenta a medida que aumenta el numero de vertices
     * en el grafo.
     */
    public int cantidadVertices() {
        int aux = vertices.size();
        return aux;
    }

    @Override
    // COMPLEJIDAD: O()
    public int cantidadArcos() {
        int aux = 0;
        for (Map.Entry<Integer, HashMap<Integer, Arco<T>>> entry : vertices.entrySet()) {
            int arcos = entry.getValue().size();
            aux = aux + arcos;
        }
        return aux;
    }

    @Override
    // COMPLEJIDAD: O()
    public Iterator<Integer> obtenerVertices() {
        Iterator<Integer> iterator = vertices.keySet().iterator();
        return iterator;
    }

    @Override
    // COMPLEJIDAD: O()
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Iterator<Integer> iterator = vertices.get(verticeId).keySet().iterator();
        return iterator;
    }

    @Override
    // COMPLEJIDAD: O()
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> arcos = new ArrayList<>();
        for (Map.Entry<Integer, HashMap<Integer, Arco<T>>> entry : vertices.entrySet()) {
            arcos.addAll(entry.getValue().values());
        }
        return arcos.iterator();
    }

    @Override
    // COMPLEJIDAD: O()
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        Iterator<Arco<T>> iterator = vertices.get(verticeId).values().iterator();
        return iterator;
    }

    @Override
    public String toString() {
        for (int verticeId : this.vertices.keySet()) {
            for (int destinoId : this.vertices.get(verticeId).keySet()) {
                System.out.println(verticeId + ": " + verticeId + " -> " + destinoId);
            }
        }
        return super.toString();
    }

    // for (Integer key: vertices.keySet()){
    // Iterator<Integer> iter = this.obtenerAdyacentes(key);
    // while (iter.hasNext())
    // System.out.println(key + " = " + iter.next());
    //

    /**
     * En el JDK 8, hashmap se ha ajustado de manera que si las claves se pueden
     * comparar para ordenarlas,
     * entonces cualquier cubo densamente poblado se implementa como un árbol,
     * de manera que incluso si hay muchas entradas con el mismo código hash, la
     * complejidad es O(log n)
     * Fuente: https://www.iteramos.com/pregunta/57110/complejidad-de-hashmap-getput
     * 
     * Por lo cual para las acciones que tengamos que ingresar al hashmap de los
     * arcos tendriamos un complejidad
     * de O(log n)2 (cuadrado)
     */

    /*
     * package tp3.graph;
     * import tp1.simple.LinkedList;
     * 
     * 
     * 
     * public class DirectedGraph<T> {
     * protected HashMap<String, Vertex<T>> vertices;
     * 
     * public DirectedGraph(){
     * vertices = new HashMap<>();
     * }
     * 
     * public void addVertex(String name, T value){
     * if(!vertices.containsKey(name)){
     * Vertex<T> vertex = new Vertex<T>(name, value);
     * vertices.put(name, vertex);
     * }
     * }
     * 
     * public void addEdge(String k1, String k2, Double weight, String label){
     * Vertex<T> v1 = vertices.get(k1);
     * Vertex<T> v2 = vertices.get(k2);
     * Edge<T> edge = new Edge<>(v1, v2, weight, label);
     * v1.addEdge(edge);
     * }
     * 
     * public boolean hasCycles(){
     * for(Vertex<T> v : vertices.values()){
     * v.setColour('w');
     * }
     * 
     * for(Vertex<T> v : vertices.values()){
     * boolean found = false;
     * if(v.getColour() == 'w'){
     * v.setColour('y');
     * found = hasCycles(v);
     * }
     * if(found){
     * return true;
     * }
     * }
     * return false;
     * }
     * 
     * protected boolean hasCycles(Vertex<T> v){
     * v.setColour('y');
     * for(Edge<T> e : v.getAdjacency()){
     * Vertex<T> endVertex = e.getV2();
     * if(endVertex.getColour() == 'w') {
     * endVertex.setColour('y');
     * return hasCycles(endVertex);
     * }
     * else if(endVertex.getColour() == 'y'){
     * return true;
     * }
     * }
     * v.setColour('b');
     * return false;
     * }
     * 
     * public void depthFirstSearch(){
     * for(Vertex<T> v : vertices.values()){
     * v.setColour('w');
     * }
     * 
     * for(Vertex<T> v : vertices.values()){
     * if(v.getColour() == 'w'){
     * v.setColour('y');
     * depthFirstSearch(v);
     * }
     * }
     * }
     * 
     * protected void depthFirstSearch(Vertex<T> v){
     * v.setColour('y');
     * for(Edge<T> e : v.getAdjacency()){
     * Vertex<T> endVertex = e.getV2();
     * if(endVertex.getColour() == 'w') {
     * System.out.println(endVertex);
     * endVertex.setColour('y');
     * depthFirstSearch(endVertex);
     * }
     * }
     * v.setColour('b');
     * }
     * 
     * public void breadthFirstSearch(){
     * LinkedList<Vertex<T>> queue = new LinkedList<>();
     * for(Vertex<T> v : vertices.values()){
     * v.setColour('w');
     * }
     * 
     * for(Vertex<T> v : vertices.values()){
     * if(v.getColour() == 'w') {
     * breadthFirstSearch(v, queue);
     * }
     * }
     * }
     * 
     * protected void breadthFirstSearch(Vertex<T> v, LinkedList<Vertex<T>> queue){
     * v.setColour('b');
     * queue.add(v);
     * 
     * while(!queue.isEmpty()){
     * Vertex<T> vertex = queue.extractFront();
     * for(Edge<T> e : vertex.getAdjacency()){
     * Vertex<T> adjacent = e.getV2();
     * if(adjacent.getColour() == 'w'){
     * adjacent.setColour('b');
     * System.out.println(adjacent);
     * queue.add(adjacent);
     * }
     * }
     * }
     * }
     * }
     */

}
