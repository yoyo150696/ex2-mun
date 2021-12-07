package api;
import java.util.*;
import java.util.Iterator;
import org.json.*;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.*;
import java.io.Reader;


public class DirectedWeightedGraph {

HashMap<Integer,NodeData> nodes = new HashMap<>();

public static class EdgeData{
    int src;
    int dest;
    double w;
    public EdgeData(int src,int dest,double w){
        this.w=w;
        this.dest=dest;
        this.src=src;
    }
}

public static class NodeData {
    HashMap<String, EdgeData> edges = new HashMap();
    private double x;
    private double y;
    private double z;
    private int id;
    public NodeData(int id){
        this.id=id;
    }
}
public NodeData getNode(int key){
    return nodes.get(key);
}

public EdgeData getEdge(int src, int dest){
    String s = Integer.toString(src);
    String d = Integer.toString(dest);


    NodeData node = getNode(src);
    return node.edges.get(s+d);
}

public void addNode(NodeData n){
    nodes.put(n.id,n);
}

public void connect(int src, int dest, double w){
    String s = Integer.toString(src);
    String d = Integer.toString(dest);
    EdgeData edge = new EdgeData(src,dest,w);

    nodes.get(src).edges.put(s+d,edge);
    nodes.get(dest).edges.put(s+d,edge);
}

public Iterator<NodeData> nodeIter(){
    return nodes.values().iterator();
}

public Iterator<EdgeData> edgeIter(){
    List<EdgeData> list = new ArrayList<>();
    Iterator<NodeData> i=nodeIter();
    while (i.hasNext()){
        Iterator<EdgeData> iE=edgeIter(i.next().id);
        while (iE.hasNext()){
            list.add(iE.next());
        }
    }

    return list.iterator();
}

public Iterator<EdgeData> edgeIter(int node_id){
    return nodes.get(node_id).edges.values().iterator();
}

public NodeData removeNode(int key){
    NodeData node;
    node = nodes.remove(key);
    return node;
}

public EdgeData removeEdge(int src, int dest){
    EdgeData edge;
    String s = Integer.toString(src);
    String d = Integer.toString(dest);

    nodes.get(src).edges.remove(s+d);
    edge = nodes.get(dest).edges.remove(s+d);
    return edge;
}

public int nodeSize(){
    return nodes.size();
}

public int edgeSize(){
    int s  = 0;
    Iterator<EdgeData> i =edgeIter();
    while (i.hasNext()){
        s++;
    }
    return s;
}






}
