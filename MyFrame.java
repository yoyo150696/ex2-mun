import api.DWGA;
import api.DirectedWeightedGraphAlgorithms;
import api.GeoLocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.io.File;

import static java.lang.Math.abs;

public class MyFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu add;
    JMenu remove;
    JMenu algo;
    JMenuItem load;
    JMenuItem save;
    JMenuItem node_a;
    JMenuItem edge_a;
    JMenuItem node_r;
    JMenuItem edge_r;
    JMenuItem isConnected;
    JMenuItem shortestPathDist;
    JMenuItem shortestPath;
    JMenuItem tsp;
    JMenuItem center;




    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
        load = new JMenuItem("load");
        save  = new JMenuItem("save");
        fileMenu.add(load);
        fileMenu.add(save);
        menuBar.add(fileMenu);
        save.addActionListener(this);
        load.addActionListener(this);

        add = new JMenu("add");
        node_a = new JMenuItem("node");
        edge_a = new JMenuItem("edge");
        add.add(node_a);
        add.add(edge_a);
        menuBar.add(add);

        remove = new JMenu("remove");
        node_r = new JMenuItem("node");
        edge_r = new JMenuItem("edge");
        remove.add(node_r);
        remove.add(edge_r);
        menuBar.add(remove);

        algo = new JMenu("algo");
        isConnected = new JMenuItem("isConnected");
        shortestPathDist = new JMenuItem("shortestPathDist");
        shortestPath = new JMenuItem("shortestPath");
        tsp = new JMenuItem("tsp");
        center = new JMenuItem("center");
        algo.add(isConnected);
        algo.add(shortestPathDist);
        algo.add(shortestPath);
        algo.add(tsp);
        algo.add(center);
        menuBar.add(algo);


        node_a.addActionListener(this);
        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }

    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==load){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                DrawingCanvas dc = new DrawingCanvas(1000,1000,file.toString());
                this.add(dc);
                repaint();
            }

        }
        if(e.getSource()==save){


        }
        if(e.getSource()==node_a){
            System.exit(0);
        }

    }
}
