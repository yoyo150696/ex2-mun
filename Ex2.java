import api.DWGA;
import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;


import javax.swing.*;

import api.NodeData;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGrapg(String json_file) {
        // ****** Add your code here ******
        //
        // ********************************
        return null;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraphAlgorithms ans = null;
        return ans;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        // ****** Add your code here ******
        //
        // ********************************
    }
    public static void main(String[] args){
        DirectedWeightedGraphAlgorithms graph = new DWGA();

        System.out.println(graph.load("C:\\Users\\yohai\\IdeaProjects\\Ex2-munche\\data\\G1.json"));
        List <NodeData> ls= new ArrayList<>();
        for (int i = 0;i<graph.getGraph().nodeSize();i++){
            ls.add(graph.getGraph().getNode(i));
        }
        MyFrame f = new MyFrame();


        f.setVisible(true);
    }
}