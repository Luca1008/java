import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Una clase para almacenar un borde de graph
class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

// Una clase para representar un objeto graph
class Graph {
    // Una lista de listas para representar una lista de adyacencia
    List<List<Integer>> adjList = new ArrayList<>();

    // Constructor para construir un grafo
    public Graph(List<Edge> edges) {
        // encuentra el vértice máximo numerado
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // asignar memoria para la lista de adyacencia
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // agrega bordes al grafo dirigido
        for (Edge current: edges) {
            // asignar un nuevo nodo en la lista de adyacencia de src a dest
            adjList.get(current.src).add(current.dest);
            // elimine el comentario debajo de la línea para el graph no dirigido
            // asignar un nuevo nodo en la lista de adyacencia de dest a src
            // adjList.get (current.dest).add (current.src);
        }
    }

    // Función para imprimir la representación de la lista de adyacencia de un graph
    public static void printGraph(Graph graph) {
        int src = 0;
        int n = graph.adjList.size();
        while (src < n) {
            // imprime el vértice actual y todos sus vértices vecinos
            for (int dest: graph.adjList.get(src)) {
                System.out.println(" (" + src + " ——> " + dest + ")" );
            }
            System.out.println();
            src++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Entrada: Lista de aristas en un dígrafo (según el diagrama anterior)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 0), new Edge(2, 1), new Edge(3, 2), new Edge(4, 5), new Edge(5, 4));

        // construye un graph a partir de la lista de aristas dada
        Graph graph = new Graph(edges);

        // imprime la representación de la lista de adyacencia del graph
        Graph.printGraph(graph);
    }
}