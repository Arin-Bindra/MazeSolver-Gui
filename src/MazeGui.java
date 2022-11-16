import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Arin Bindra
 *
 */

public class MazeGui extends JFrame {
    
    private ArrayList<Edge> edges;
    private Node[] nodes;
    
    public MazeGui()
    {
        setTitle("Maze | Arin Bindra");
        setSize(750, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //--------------------------------------------------------------------------
    
    public void setEdges(ArrayList<Edge> edges)
    {
        this.edges = edges;
    }
    
    //--------------------------------------------------------------------------
    
    public void setNodes(Node[] nodes)
    {
        this.nodes = nodes;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public void paint(Graphics g)
    {
        for(int i=0; i < this.edges.size(); i++)
        {
            if(this.edges.get(i).getPath() == true)
            {
                g.setColor(Color.MAGENTA);
            }
            else
            {
                g.setColor(Color.orange);
            }
            
            g.drawLine(this.edges.get(i).getN1().getX() + 60, this.edges.get(i).getN1().getY() + 60 
                    ,this.edges.get(i).getN2().getX() + 60, this.edges.get(i).getN2().getY() + 60);
        }
        
        g.setColor(Color.blue);
        
        for(int i=0; i < this.nodes.length; i++)
        {
            if(i == this.nodes.length - 1)
            {
                g.setColor(Color.red);
            }
            g.fillOval(this.nodes[i].getX() + 50, this.nodes[i].getY() + 50, 20, 20);
        }
        
        g.setFont(new Font("Courier", 1, 18));
        g.setColor(Color.black);
        
        for(int i=0; i < this.nodes.length; i++)
        {
            String name = this.nodes[i].getName();
            
            if(name.equalsIgnoreCase("w"))
            {
                name = "EXIT";
            }
            
            g.drawString(name, this.nodes[i].getX() + 45, this.nodes[i].getY() + 45);
        }
        
        g.setFont(new Font("Courier", 1, 14));
        g.drawString("Path between nodes", this.getWidth() - 250, this.getHeight() - 50);
        g.drawString("Path from starting node to exit node", this.getWidth() - 250, this.getHeight() - 75);
        
        g.setColor(Color.ORANGE);
        g.drawLine(this.getWidth() - 320, this.getHeight() - 55, this.getWidth() - 260, this.getHeight() - 55);
        g.setColor(Color.MAGENTA);
        g.drawLine(this.getWidth() - 320, this.getHeight() - 80, this.getWidth() - 260, this.getHeight() - 80);
    }
    
    //--------------------------------------------------------------------------
    
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser(new File("."));
        int stateImageFileChooser = fileChooser.showOpenDialog(null);
        
        String fileName = "";
        
        if(stateImageFileChooser == JFileChooser.APPROVE_OPTION)
        {
            fileName = fileChooser.getSelectedFile().getPath();
        }
        
        FileData data = new FileData(fileName);
        
        MazeGui gui = new MazeGui();
        
        gui.setNodes(data.getNodes());
        gui.setEdges(data.getEdges());
        
        gui.paint(null);
    }
}
