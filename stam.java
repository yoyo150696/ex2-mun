package api;

import java.util.List;

public class stam implements DirectedWeightedGraphAlgorithms{
    DirectedWeightedGraph graph;
    @Override
    public void init(DirectedWeightedGraph g) {
        this.graph=g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return graph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph g=new DirectedWeightedGraph();

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }
}
