package datastructure.graph;

import java.util.*;

/**
 * Search value in a Graph using BFS or DFS
 */
public class GraphSearch {
    static class Vertex{
        int value;
        List<Vertex> adjVertices;
        boolean visited;

        public Vertex(int value){
            this.value = value;
            adjVertices = new LinkedList<>();
        }

        public void addEdge(Vertex v){
            adjVertices.add(v);
        }

        public void setVisited(){
            visited = true;
        }
        public boolean isVisited(){
            return visited;
        }
    }

    public void BFS(Vertex src){
        src.setVisited();

        java.util.Queue<Vertex> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            Vertex temp = queue.poll();
            System.out.println(temp.value);
            for(Vertex v: temp.adjVertices){
                if(!v.isVisited())
                    queue.offer(v);
            }
        }
    }

    public  void DFS(Vertex src){
        System.out.println(src.value);
        src.setVisited();
        for(Vertex v: src.adjVertices){
            if(!v.isVisited())
                DFS(v);
        }
    }



}
