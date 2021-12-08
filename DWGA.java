package Ex2.src.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.google.gson.*;
import java.io.FileReader;

public class DWGA implements DirectedWeightedGraphAlgorithms{
    private DirectedWeightedGraph graph;
    @Override
    public void init(DirectedWeightedGraph g) {
        graph=g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return graph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        return null;
    }

    @Override
    public boolean isConnected() {
        int nodeCount=0,edgesCount=0;
        Iterator<NodeData> nI=graph.nodeIter();
        Iterator<EdgeData> eI= graph.edgeIter();
        while (nI.hasNext()){
            nodeCount++;
            nI.next();
        }
        while (eI.hasNext()){
            edgesCount++;
            eI.next();
        }
        return nodeCount*(nodeCount-1)==edgesCount;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        ArrayList<EdgeData> visited=new ArrayList<>();
        NodeData first=graph.getNode(src);
        NodeData last=graph.getNode(dest);
        List<NodeData> path=new ArrayList<>();
        path.add(first);
        NodeData cur=first;
        double dis=0;
        List<NodeData> ShortestPath=new ArrayList<>();
        double shortestDis=999999999;
        while(visited.size()<(graph.edgeSize()-last.getEdges().size())){
            if (cur==last){
                if(shortestDis>dis){
                    ShortestPath=path;
                    shortestDis=dis;
                }
                cur=path.get(path.size()-2);
                path.remove(path.size()-1);
            }
            Iterator<EdgeData> curNa =graph.edgeIter(cur.getKey());
            if(curNa.hasNext()) {
                EdgeData e = curNa.next();
                double shortest = e.getWeight();
                EdgeData closestE = e;
                while (curNa.hasNext()) {
                    if (shortest > e.getWeight() && !visited.contains(e)) {
                        closestE = e;
                        shortest = e.getWeight();
                    }
                    e = curNa.next();
                }
                if (!visited.contains(closestE)) {
                    visited.add(closestE);
                    path.add(graph.getNode(closestE.getDest()));
                    shortestDis = shortestDis + shortest;
                    cur = graph.getNode(closestE.getDest());
                } else {
                    if(path.size()<2){
                        return -1;
                    }
                    cur = path.get(path.size() - 2);
                    path.remove(path.size() - 1);
                }
            }else{
                if(path.size()<2){
                    return -1;
                }
                cur = path.get(path.size() - 2);
                path.remove(path.size() - 1);
            }
        }
        return shortestDis;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        ArrayList<EdgeData> visited=new ArrayList<>();
        NodeData first=graph.getNode(src);
        NodeData last=graph.getNode(dest);
        List<NodeData> path=new ArrayList<>();
        path.add(first);
        NodeData cur=first;
        double dis=0;
        List<NodeData> ShortestPath=new ArrayList<>();
        double shortestDis=999999999;
        while(visited.size()<(graph.edgeSize()-last.getEdges().size())){
            if (cur==last){
                if(shortestDis>dis){
                    ShortestPath=path;
                    shortestDis=dis;
                }
                cur=path.get(path.size()-2);
                path.remove(path.size()-1);
            }
            Iterator<EdgeData> curNa =graph.edgeIter(cur.getKey());
            if(curNa.hasNext()) {
                EdgeData e = curNa.next();
                double shortest = e.getWeight();
                EdgeData closestE = e;
                while (curNa.hasNext()) {
                    if (shortest > e.getWeight() && !visited.contains(e)) {
                        closestE = e;
                        shortest = e.getWeight();
                    }
                    e = curNa.next();
                }
                if (!visited.contains(closestE)) {
                    visited.add(closestE);
                    path.add(graph.getNode(closestE.getDest()));
                    shortestDis = shortestDis + shortest;
                    cur = graph.getNode(closestE.getDest());
                } else {
                    if(path.size()<2){
                        return null;
                    }
                    cur = path.get(path.size() - 2);
                    path.remove(path.size() - 1);
                }
            }else{
                if(path.size()<2){
                    return null;
                }
                cur = path.get(path.size() - 2);
                path.remove(path.size() - 1);
            }
        }
        return ShortestPath;
    }

    @Override
    public NodeData center() {
        if(!isConnected()){
            return null;
        }
        Iterator<NodeData> iN=graph.nodeIter();
        NodeData curNode= iN.next();
        NodeData bestNode=curNode;
        double min=999999999;
        while (iN.hasNext()){
            Iterator<NodeData> iNC=graph.nodeIter();
            NodeData curNodeCheck= iNC.next();

            if(curNodeCheck==curNode){
                curNodeCheck=iNC.next();
            }
            double max=shortestPathDist(curNode.getKey(),curNodeCheck.getKey());
            while (iNC.hasNext()){
                if(curNode!=curNodeCheck) {
                    double curDis = shortestPathDist(curNode.getKey(), curNodeCheck.getKey());
                    if (max < curDis) {
                        max = curDis;

                    }
                }
                curNodeCheck=iNC.next();
            }
            if (max<min){
                min=max;
                bestNode=curNode;
            }
            curNode=iN.next();
        }
        return bestNode;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        Iterator<NodeData> NI=graph.nodeIter();
        NodeData first=NI.next();
        List<NodeData> bestPath = new ArrayList<>();
        double mindis=999999999;
        while (NI.hasNext()) {
            ArrayList<EdgeData> visited = new ArrayList<>();
            List<NodeData> path = new ArrayList<>();
            path.add(first);
            NodeData cur = first;
            double dis = 0;
            List<NodeData> ShortestPath = new ArrayList<>();
            double shortestDis = 999999999;
            while (visited.size() < graph.edgeSize()) {
                if (path.size() == graph.nodeSize()) {
                    if (shortestDis > dis) {
                        ShortestPath = path;
                        shortestDis = dis;
                    }
                    cur = path.get(path.size() - 2);
                    path.remove(path.size() - 1);
                }
                Iterator<EdgeData> curNa = graph.edgeIter(cur.getKey());
                if (curNa.hasNext()) {
                    EdgeData e = curNa.next();
                    double shortest = e.getWeight();
                    EdgeData closestE = e;
                    while (curNa.hasNext()) {
                        if (shortest > e.getWeight() && !visited.contains(e)) {
                            closestE = e;
                            shortest = e.getWeight();
                        }
                        e = curNa.next();
                    }
                    if (!visited.contains(closestE)) {
                        visited.add(closestE);
                        path.add(graph.getNode(closestE.getDest()));
                        shortestDis = shortestDis + shortest;
                        cur = graph.getNode(closestE.getDest());
                    } else {
                        if (path.size() < 2) {
                            return null;
                        }
                        cur = path.get(path.size() - 2);
                        path.remove(path.size() - 1);
                    }
                } else {
                    if (path.size() < 2) {
                        return null;
                    }
                    cur = path.get(path.size() - 2);
                    path.remove(path.size() - 1);
                }
            }
            if(shortestDis<mindis){
                bestPath=ShortestPath;
                mindis=shortestDis;
            }

            first=NI.next();
        }
        return bestPath;
    }

    @Override
    public boolean save(String file) {

        return true;


    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
