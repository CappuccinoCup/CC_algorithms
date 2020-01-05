package data_structures_and_algorithm_analysis.graph_data_structure;

import java.util.LinkedList;

/* Basic vertex class */
public class Vertex {

    private String name;
    private LinkedList<Edge> edges;// adjacent list

    Vertex(){
        
    }

    Vertex(String name){
        this.name = name;
        edges = new LinkedList<>();
    }

    /**
     * return the name of this vertex
     */
    public String getName(){
        return name;
    }

    /**
     * @return a linkedlist containing all edges start from this vertex
     */
    public LinkedList<Edge> getEdges(){
        return edges;
    }
}