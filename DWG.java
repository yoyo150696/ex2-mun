package Ex2.src.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DWG implements DirectedWeightedGraph{
    private HashMap<Integer,NodeData> nodes=new HashMap<>();
    @Override
    public NodeData getNode(int key) {
        return nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        String s = Integer.toString(src);
        String d = Integer.toString(dest);


        NodeData node = getNode(src);
        return node.getEdge(s+d);
    }

    @Override
    public void addNode(NodeData n) {
        nodes.put(n.getKey(),n);
    }

    @Override
    public void connect(int src, int dest, double w) {
        String s = Integer.toString(src);
        String d = Integer.toString(dest);
        EdgeData edge = new ED(src,w,dest);

        nodes.get(src).getEdges().put(s+d,edge);

    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return nodes.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        List<EdgeData> list = new ArrayList<>();
        Iterator<NodeData> i=nodeIter();
        while (i.hasNext()){
            Iterator<EdgeData> iE=edgeIter(i.next().getKey());
            while (iE.hasNext()){
                list.add(iE.next());
            }
        }
        return list.iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return nodes.get(node_id).getEdges().values().iterator();    }

    @Override
    public NodeData removeNode(int key) {
        NodeData node;
        node = nodes.remove(key);
        return node;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData edge;
        String s = Integer.toString(src);
        String d = Integer.toString(dest);

        nodes.get(src).getEdges().remove(s+d);
        edge = nodes.get(dest).getEdges().remove(s+d);
        return edge;
    }

    @Override
    public int nodeSize() {
        return nodes.size();
    }

    @Override
    public int edgeSize() {
        int s  = 0;
        Iterator<EdgeData> i =edgeIter();
        while (i.hasNext()){
            s++;
        }
        return s;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
