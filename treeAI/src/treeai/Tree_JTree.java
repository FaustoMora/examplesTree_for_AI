/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* fuente:http://www.codejava.net/java-se/swing/jtree-basic-tutorial-and-examples*/
package treeai;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
 
public class Tree_JTree extends JFrame
{
    private JTree tree;
    public Tree_JTree()
    {
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        for(int i=1;i<6;i++){
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("hijo"+i);
            root.add(hijo);
            
            for(int j=1;j<6;j++){
                DefaultMutableTreeNode nieto = new DefaultMutableTreeNode("nieto"+i+"."+j);
                hijo.add(nieto);
                
                for(int k=1;k<6;k++){
                    DefaultMutableTreeNode bisnieto = new DefaultMutableTreeNode("bisnieto"+i+"."+j+"."+k);
                    nieto.add(bisnieto);
                }
            }
        }
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        add(tree);
        add(new JScrollPane(tree));
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tree_JTree();
            }
        });
    }       
}
