package data_structures_and_algorithm_analysis.graph_algorithm;

import data_structures_and_algorithm_analysis.graph_data_structure.*;

public class ArticulationPoint {
    // Cation: in this case, in class MyVertex:
    // topNum = num;    known = visited;    path = parent;  dist = low;
    public static MyGraph myGraph;
    public static MyVertex V;
    public static int VChild;
    public static int counter;

    public static void findArt(MyGraph graph, MyVertex v){
        myGraph = graph;
        V = v;
        VChild = 0;
        counter = 1;

        findArt(v);
    }
    private static void findArt(MyVertex v){
        v.known = true;
        v.dist = v.topNum = counter++;
        for(Edge e : v.getEdges()){
            MyVertex w = (MyVertex)e.getDV();
            if(!w.known){
                w.path = v;
                if(v == V) VChild++;
                findArt(w);
                if((w.dist >= v.topNum && v != V) || (VChild > 1 && v == V))
                    System.out.println(v.getName() + " is an articulation point");
                v.dist = Math.min(v.dist, w.dist);  // Rule 3
            }
            else if(v.path != w)
                v.dist = Math.min(v.dist, w.topNum);    // Rule 2
        }
    }

    public static void findArt_low(MyGraph graph, MyVertex v){
        myGraph = graph;
        V = v;
        VChild = 0;
        counter = 1;

        assignNum(v);
        assignLow(v);
    }
    // Assign Num and compute parents
    private static void assignNum(MyVertex v){
        v.topNum = counter++;
        for(Edge e : v.getEdges()){
            MyVertex w = (MyVertex)e.getDV();
            if(!w.known){
                w.path = v;
                if(v == V) VChild++;
                assignNum(w);
            }
        }
    }
    // Assign low; also check for articulation points
    private static void assignLow(MyVertex v){
        v.dist = v.topNum;  // Rule 1
        for(Edge e : v.getEdges()){
            MyVertex w = (MyVertex)e.getDV();
            if(w.topNum > v.topNum){ // Forward edge
                assignLow(w);
                if((w.dist >= v.topNum && v != V) || (VChild > 1 && v == V))
                    System.out.println(v.getName() + " is an articulation point");
                v.dist = Math.min(v.dist, w.dist);  // Rule 3
            }
            else if(v.path != w)
                v.dist = Math.min(v.dist, w.topNum);    // Rule 2
        }
    }
}