package data_structures_and_algorithm_analysis;

import data_structures_and_algorithm_analysis.graph_algorithm.*;
import data_structures_and_algorithm_analysis.graph_data_structure.*;

public class Test{
    public static void main(String[] args) {
        /* quick sort test */
        // int size = 1000;
        // Integer[] a = CommonFunc.randomInteger(size);
        // Quicksort.quicksort(a);
        // for(Integer x : a)
        //     System.out.print(x + " ");

        /* radix sort test */
        // String[] str = CommonFunc.randomString(100, 14, false);
        // RadixSort.radixSort(str, 14);
        // for(String s : str)
        //     System.out.println(s);
        // System.out.println();
        /* dijkstra test */
        // MyGraph map = new MyGraph();
        // MyVertex v1 = map.addVertex("v1");MyVertex v2 = map.addVertex("v2");MyVertex v3 = map.addVertex("v3");
        // MyVertex v4 = map.addVertex("v4");MyVertex v5 = map.addVertex("v5");MyVertex v6 = map.addVertex("v6");
        // MyVertex v7 = map.addVertex("v7");
        // map.addEdge(v1, v4, 1);map.addEdge(v1, v2, 2);map.addEdge(v2, v4, 3);map.addEdge(v2, v5, 10);
        // map.addEdge(v3, v1, 4);map.addEdge(v3, v6, 5);map.addEdge(v4, v3, 2);map.addEdge(v4, v5, 2);
        // map.addEdge(v4, v6, 8);map.addEdge(v4, v7, 4);map.addEdge(v5, v7, 6);map.addEdge(v7, v6, 1);
        // ShortestPath.dijkstra(map, v1);
        // ShortestPath.printPath(v1);ShortestPath.printPath(v2);ShortestPath.printPath(v3);
        // ShortestPath.printPath(v4);ShortestPath.printPath(v5);ShortestPath.printPath(v6);
        // ShortestPath.printPath(v7);

        /* topsort test */
        // MyGraph map = new MyGraph();
        // MyVertex v1 = map.addVertex("v1");MyVertex v2 = map.addVertex("v2");MyVertex v3 = map.addVertex("v3");
        // MyVertex v4 = map.addVertex("v4");MyVertex v5 = map.addVertex("v5");MyVertex v6 = map.addVertex("v6");
        // MyVertex v7 = map.addVertex("v7");
        // map.addEdge(v1, v2);map.addEdge(v1, v3);map.addEdge(v1, v4);map.addEdge(v2, v4);
        // map.addEdge(v2, v5);map.addEdge(v3, v6);map.addEdge(v4, v3);map.addEdge(v4, v6);
        // map.addEdge(v4, v7);map.addEdge(v5, v4);map.addEdge(v5, v7);map.addEdge(v7, v6);
        // Topsort.topsort(map);
        // ShortestPath.unweighted(map, v1);
        // ShortestPath.printPath(v1);ShortestPath.printPath(v2);ShortestPath.printPath(v3);
        // ShortestPath.printPath(v4);ShortestPath.printPath(v5);ShortestPath.printPath(v6);
        // ShortestPath.printPath(v7);

        /* findArt test */
        MyGraph map = new MyGraph();
        MyVertex A = map.addVertex("A");MyVertex B = map.addVertex("B");MyVertex C = map.addVertex("C");
        MyVertex D = map.addVertex("D");MyVertex E = map.addVertex("E");MyVertex F = map.addVertex("F");
        MyVertex G = map.addVertex("G");/* MyVertex H = map.addVertex("H");map.addEdge(A, H);map.addEdge(H, A); */
        map.addEdge(A, B);map.addEdge(B, A);map.addEdge(A, D);map.addEdge(D, A);
        map.addEdge(B, C);map.addEdge(C, B);map.addEdge(C, D);map.addEdge(D, C);
        map.addEdge(C, G);map.addEdge(G, C);map.addEdge(D, E);map.addEdge(E, D);
        map.addEdge(D, F);map.addEdge(F, D);map.addEdge(E, F);map.addEdge(F, E);
        ArticulationPoint.findArt(map, A);
    }
}