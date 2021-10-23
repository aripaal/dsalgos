package datastructure.graph;

import org.junit.*;

import static org.junit.Assert.*;
import static datastructure.graph.GraphSearch.Vertex;
public class GraphSearchTest {
    Vertex v1,v2,v3,v4,v5;

    @Before
    public void setup(){
        v1 = new Vertex(1);
        v2 = new Vertex(2);
        v3 = new Vertex(3);
        v4 = new Vertex(4);
        v5 = new Vertex(5);

        v1.addEdge(v2);
        v1.addEdge(v4);
        v4.addEdge(v5);
        v2.addEdge(v3);
    }

    @Test
    public void testBFS(){
       GraphSearch search = new GraphSearch();
       search.BFS(v1);
    }
    @Test
    public void testDFS(){
        GraphSearch search = new GraphSearch();
        search.DFS(v1);
    }
}