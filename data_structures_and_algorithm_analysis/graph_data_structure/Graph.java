package data_structures_and_algorithm_analysis.graph_data_structure;

import java.util.ArrayList;

/* Basic graph class */
public class Graph {

    protected ArrayList<Vertex> vertexes;
    protected ArrayList<Edge> edges;

    public Graph(){
        vertexes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * add a new vertex to this graph with a name
     * allow more than one vertexes have the same name
     * @param name the name of a new vertex
     * @return the vertex added
     */
    public Vertex addVertex(String name){
        Vertex v = new Vertex(name);
        vertexes.add(v);
        return v;
    }

    /**
     * add a new edge from a vertex to a vertex
     * allow more than one edges from a vertex to a vertex
     * @param from starting vertex
     * @param to destination vertex
     * @return the edge added
     */
    public Edge addEdge(Vertex from, Vertex to){
        return addEdge(from, to, 0);
    }
    
    /**
     * add a new edge from a vertex to a vertex with a weight
     * @param from starting vertex
     * @param to destination vertex
     * @param value weight of the edge
     * @return the edge added
     */
    public Edge addEdge(Vertex from, Vertex to, int value){
        Edge e = new Edge(from, to, value);
        from.getEdges().add(e);
        edges.add(e);
        return e;
    }

    /* return add vertexes */
    public ArrayList<Vertex> getVertexes(){
        return vertexes;
    }

    /* return add edges */
    public ArrayList<Edge> getEdges(){
        return edges;
    }
}