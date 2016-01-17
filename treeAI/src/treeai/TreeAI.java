/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeai;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.Tree;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Dr. Greg M. Bernstein
 */
public class TreeAI {
    Graph<Integer, String> g;
    Forest<Vertex, Integer> arbol;
    TreeLayout<Vertex, Integer> layout_tree;
    /** Creates a new instance of SimpleGraphView */
    public TreeAI() {
        // Graph<V, E> where V is the type of the vertices and E is the type of the edges
        arbol = new DelegateForest<Vertex,Integer>();
        g = new SparseMultigraph<Integer, String>();
        layout_tree = new TreeLayout<Vertex, Integer>(arbol);
        // Add some vertices. From above we defined these to be type Integer.
        g.addVertex((Integer)0);
        for(int i=1;i <6;i++){
            g.addVertex((Integer)i);
            g.addEdge("Edge-"+i, 0, i);
        }
        g.addVertex((Integer)11);
        g.addEdge("Edge-"+11, 1, 11);
        g.addVertex((Integer)12);
        g.addEdge("Edge-"+12, 1, 12);
        g.addVertex((Integer)13);
        g.addEdge("Edge-"+13, 1, 13);
        g.addVertex((Integer)14);
        g.addEdge("Edge-"+14, 1, 14);
        g.addVertex((Integer)15);
        g.addEdge("Edge-"+15, 1, 15);
        
        g.addVertex((Integer)21);
        g.addEdge("Edge-"+21, 2, 21);
        g.addVertex((Integer)22);
        g.addEdge("Edge-"+22, 2, 22);
        g.addVertex((Integer)23);
        g.addEdge("Edge-"+23, 2, 23);
        g.addVertex((Integer)24);
        g.addEdge("Edge-"+24, 2, 24);
        g.addVertex((Integer)25);
        g.addEdge("Edge-"+25, 2, 25);
        // Note that the default is for undirected edges, our Edges are Strings.
        //g.addEdge("Edge-A", 1, 2); // Note that Java 1.5 auto-boxes primitives
        //g.addEdge("Edge-B", 2, 3);  
    }
    

    public static void main(String[] args) {
        TreeAI sgv = new TreeAI(); //We create our graph in here
        // The Layout<V, E> is parameterized by the vertex and edge types
        Layout<Integer, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(300,300)); // sets the initial size of the layout space
        // The BasicVisualizationServer<V,E> is parameterized by the vertex and edge types
        BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
        vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        
        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); 
        frame.pack();
        frame.setVisible(true);       
    }
    
}
