import api.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sound.sampled.Line;
import javax.swing.*;

import static java.lang.Math.abs;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;
    private String file;
    public DrawingCanvas(int w,int h,String f){
        width = w;
        height = h;
        file = f;
    }


    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        List <GeoLocation> arr = new ArrayList<>();
        List <GeoLocation> arr_n = new ArrayList<>();
        List <Double> arr_disx = new ArrayList<>();
        List <Double> arr_disy = new ArrayList<>();

        DirectedWeightedGraphAlgorithms graph = new DWGA();
        graph.load(file);

        double max_x = graph.getGraph().getNode(0).getLocation().x();
        double min_x = graph.getGraph().getNode(0).getLocation().x();
        double max_y = graph.getGraph().getNode(0).getLocation().y();
        double min_y = graph.getGraph().getNode(0).getLocation().y();
        for (int i = 0;i<graph.getGraph().nodeSize();i++){
            double x = graph.getGraph().getNode(i).getLocation().x();
            double y = graph.getGraph().getNode(i).getLocation().y();
            if(max_x<x)
                max_x = x;
            if(min_x>x)
                min_x = x;
            if(max_y<y)
                max_y = y;
            if(min_y>y)
                min_y = y;
        }
        double abs_x = abs(max_x-min_x);
        double abs_y = abs(max_y - min_y);
        double scale_x = width*0.6/abs_x;
        double scale_y = height*0.6/abs_y;
        System.out.println(scale_x);
        System.out.println(scale_y);
        System.out.println(width);
        System.out.println(height);
        System.out.println(abs_x);
        System.out.println(abs_y);
        for (int i = 0; i<graph.getGraph().nodeSize();i++){
            arr.add(graph.getGraph().getNode(i).getLocation());
            double dis_x = (graph.getGraph().getNode(i).getLocation().x()-min_x)*scale_x;
            double dis_y = (graph.getGraph().getNode(i).getLocation().y()-min_y)*scale_y;
            arr_disx.add(dis_x);
            arr_disy.add(dis_y);
            System.out.println(arr_disy.get(i));
            System.out.println(arr_disx.get(i));
            Ellipse2D.Double shape = new Ellipse2D.Double(arr_disx.get(i), arr_disy.get(i), 10, 10);
            ((Graphics2D) g).fill(shape);



        }
        for (int i = 0;i<graph.getGraph().nodeSize();i++){
            Iterator<EdgeData> edge_I = graph.getGraph().edgeIter(i);
            while (edge_I.hasNext()) {
                EdgeData edge = edge_I.next();
                Path2D.Double p = new Path2D.Double();
                p.moveTo(arr_disx.get(edge.getSrc()),arr_disy.get(edge.getSrc()));
                p.lineTo(arr_disx.get(edge.getDest()),arr_disy.get(edge.getDest()));


                g2d.draw(p);
            }
        }






    }

}

