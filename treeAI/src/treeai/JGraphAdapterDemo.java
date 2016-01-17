/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeai;

/**
 *
 * @author dark-legion
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dark-legion
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 *
 * @since Aug 3, 2003
 */
public class JGraphAdapterDemo extends JApplet {
    private static final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
    private static final Dimension DEFAULT_SIZE = new Dimension( 1000, 1050 );

    // 
    private JGraphModelAdapter m_jgAdapter;

    /**
     * @see java.applet.Applet#init().
     */
    public void init(  ) {
        // create a JGraphT graph
        ListenableGraph g = new ListenableDirectedGraph( DefaultEdge.class );

        // create a visualization using JGraph, via an adapter
        m_jgAdapter = new JGraphModelAdapter( g );

        JGraph jgraph = new JGraph( m_jgAdapter );

        adjustDisplaySettings( jgraph );
        getContentPane(  ).add( jgraph );
        resize( DEFAULT_SIZE );

        // add some sample data (graph manipulated via JGraphT)
        g.addVertex( "v0" );
        g.addVertex( "v1" );
        g.addVertex( "v2" );
        g.addVertex( "v3" );
        g.addVertex( "v4" );
        g.addVertex( "v5" );
        
        g.addVertex( "v21" );
        g.addVertex( "v22" );
        g.addVertex( "v23" );
        g.addVertex( "v24" );
        g.addVertex( "v25" );
        
        g.addVertex( "v11" );
        g.addVertex( "v12" );
        g.addVertex( "v13" );
        g.addVertex( "v14" );
        g.addVertex( "v15" );
        

        g.addEdge( "v0", "v1" );
        g.addEdge( "v0", "v2" );
        g.addEdge( "v0", "v3" );
        g.addEdge( "v0", "v4" );
        g.addEdge( "v0", "v5" );
        
        g.addEdge( "v1", "v11" );
        g.addEdge( "v1", "v12" );
        g.addEdge( "v1", "v13" );
        g.addEdge( "v1", "v14" );
        g.addEdge( "v1", "v15" );

        // position vertices nicely within JGraph component
        positionVertexAt( "v0", 500, 30 );
        positionVertexAt( "v1", 100, 80 );
        positionVertexAt( "v2", 300, 80 );
        positionVertexAt( "v3", 500, 80 );
        positionVertexAt( "v4", 700, 80 );
        positionVertexAt( "v5", 900, 80 );
        //segundo nivel
        positionVertexAt( "v11", 40, 150 );
        positionVertexAt( "v12", 80, 150 );
        positionVertexAt( "v13", 120, 150 );
        positionVertexAt( "v14", 160, 150 );
        positionVertexAt( "v15", 200, 150 );
        // that's all there is to it!...
    }


    private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );

        Color  c        = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter( "bgcolor" );
        }
         catch( Exception e ) {}

        if( colorStr != null ) {
            c = Color.decode( colorStr );
        }

        jg.setBackground( c );
    }


    private void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );
        Map attr = cell.getAttributes(  );
        Rectangle2D b = GraphConstants.getBounds( attr );

        GraphConstants.setBounds( attr, new Rectangle( x, y, (int)b.getWidth(),(int)b.getHeight() ) );

        Map cellAttr = new HashMap(  );
        cellAttr.put( cell, attr );
        m_jgAdapter.edit( cellAttr, null, null, null);
    }
}

