package data_structures_and_algorithm_analysis.graph_data_structure;


public class MyGraph extends Graph {
    
    public MyGraph(){
        super();
    }

    public MyVertex addVertex(String name){
        MyVertex v = new MyVertex(name);
        vertexes.add(v);
        return v;
    }
}