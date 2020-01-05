package data_structures_and_algorithm_analysis.graph_data_structure;

/* Basic edge class */
public class Edge {

    private Vertex v1;// starting
    private Vertex v2;// destination
    private int weight;

    Edge(){

    }
    
    /**
     * @param from starting vertex
     * @param to destination vertex
     * @param value weight of this edge
     */
    Edge(Vertex from, Vertex to, int value){
        v1 = from;
        v2 = to;
        weight = value;
    }

    /**
     * @return starting vertex
     */
    public Vertex getSV(){
        return v1;
    }

    /**
     * @return destination vertex
     */
    public Vertex getDV(){
        return v2;
    }

    /**
     * @return weight of this edge
     */
    public int getWeight(){
        return weight;
    }
}