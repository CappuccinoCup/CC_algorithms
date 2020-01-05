package data_structures_and_algorithm_analysis.graph_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import data_structures_and_algorithm_analysis.graph_data_structure.*;

public class ShortestPath{

    public static MyGraph myGraph;

    public static void unweighted(MyGraph graph, MyVertex s){
        myGraph = graph;
        Queue<MyVertex> q = new LinkedList<MyVertex>();

        for(Vertex v : myGraph.getVertexes())
            ((MyVertex)v).dist = MyVertex.INFINITY;

        s.dist = 0;
        q.offer(s);

        while(!q.isEmpty()){
            MyVertex v = q.poll();

            for(Edge e : v.getEdges()){
                MyVertex w = (MyVertex)e.getDV();
                if(w.dist == MyVertex.INFINITY){
                    w.dist = v.dist + 1;
                    w.path = v;
                    q.offer(w);
                }
            }
        }
    }

    public static void dijkstra(MyGraph graph, MyVertex s){
        myGraph = graph;
        dijkstra(s);
    }

    public static void weightedNegative(MyGraph graph, MyVertex s){
        myGraph = graph;
        Queue<MyVertex> q = new LinkedList<MyVertex>();

        for(Vertex v : myGraph.getVertexes())
            ((MyVertex)v).dist = MyVertex.INFINITY;

        s.dist = 0;
        q.offer(s);

        while(!q.isEmpty()){
            MyVertex v = q.poll();

            for(Edge e : v.getEdges()){
                MyVertex w = (MyVertex)e.getDV();
                if(v.dist + e.getWeight() < w.dist){
                    // Update w
                    w.dist = v.dist + e.getWeight();
                    w.path = v;
                    if(!q.contains(w))
                        q.offer(w);
                }
            }
        }
    }

    public static void printPath(MyVertex v){
        print(v);
        System.out.println("  distance: " + v.dist);
    }
    
    private static void dijkstra(MyVertex s){
        ArrayList<Vertex> vertexs = myGraph.getVertexes();
        for(Vertex v : vertexs){
            ((MyVertex)v).dist = MyVertex.INFINITY;
            ((MyVertex)v).known = false;
        }

        s.dist = 0;

        MyVertex v;
        while((v = getSmallestUnknown()) != null){
            v.known = true;

            for(Edge e : v.getEdges()){
                MyVertex w = (MyVertex)(e.getDV());
                if(!w.known){
                    int cvw = e.getWeight();

                    if(v.dist + cvw < w.dist){
                        w.dist = v.dist + cvw;
                        w.path = v;
                    }
                }
            }
        }
    }

    private static MyVertex getSmallestUnknown(){
        MyVertex result = null;
        int smallest = MyVertex.INFINITY;
        for(Vertex v : myGraph.getVertexes()){
            MyVertex myV = (MyVertex)v;
            if(!myV.known && myV.dist < smallest){
                result = myV;
                smallest = myV.dist;
            }
        }
        return result;
    }

    private static void print(MyVertex v){
        if(v.path != null){
            print(v.path);
            System.out.print(" to ");
        }
        System.out.print(v.getName());
    }
}