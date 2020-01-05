package data_structures_and_algorithm_analysis.graph_data_structure;

public class MyVertex extends Vertex{
    public static final int INFINITY = 999999;

    public int indegree;
    public int topNum;// or num
    public boolean known;// or visited
    public int dist;// or low
    public MyVertex path;// or parent

    public MyVertex(String name){
        super(name);
        indegree = 0;
        topNum = 0;
        known = false;
        dist = INFINITY;
    }
}