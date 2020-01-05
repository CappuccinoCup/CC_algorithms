package data_structures_and_algorithm_analysis.graph_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import data_structures_and_algorithm_analysis.graph_data_structure.*;

public class Topsort{
    public static void topsort(MyGraph graph){
        Queue<MyVertex> q = new LinkedList<>();
        int count = 0;

        for(Vertex v : graph.getVertexes())
            ((MyVertex)v).indegree = 0;
        for(Edge e : graph.getEdges())
            ((MyVertex)e.getDV()).indegree++;
        
        for(Vertex v : graph.getVertexes())
            if(((MyVertex)v).indegree == 0)
                q.offer((MyVertex)v);
        
        while(!q.isEmpty()){
            MyVertex v = q.poll();
            v.topNum = count++;
            for(Edge e : v.getEdges())
                if((--((MyVertex)e.getDV()).indegree) == 0)
                    q.offer((MyVertex)e.getDV());
        }

        if(count < graph.getVertexes().size())
            System.out.println("Error: Cycle exists!");
        /*else*/    
            topsortPrint(graph);
    }

    private static void topsortPrint(MyGraph graph){
        ArrayList<Vertex> vs = graph.getVertexes();
        MyVertex[] buckets = new MyVertex[vs.size()];

        for(Vertex v : vs)
            buckets[((MyVertex)v).topNum] = (MyVertex)v;

        for(MyVertex v : buckets)
            System.out.print(v.getName() + " ");

        System.out.println();
    }
}