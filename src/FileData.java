/**
 * Arin Bindra
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileData {
    
    private ArrayList<String> lines;
    private String[] names;
    private int[] x;
    private int[] y;
    private int[][] matrix;
    private String[] next1;
    private String[] next2;
    private Node[] nodes;
    private ArrayList<Edge> edges;
    
    public FileData(String file)
    {
        this.readFile(file);
        this.sortData();
        this.createNodes();
        this.createEdges();
        this.createMatrix();
        
        PathFinder pf = new PathFinder(this.matrix);
        
        this.convertPath(pf.findPath(0, this.nodes.length - 1));
    }
    
    //--------------------------------------------------------------------------
    
    private void readFile(String file)
    {
        this.lines = new ArrayList<>();
        
        try
        {
            BufferedReader inStream = new BufferedReader(new FileReader(file));
           
            String line = null;
        
            while((line = inStream.readLine()) != null)
            {
                this.lines.add(line);
            }
            inStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        
        catch(IOException e)
        {
            System.out.println("Error reading from file");
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void sortData()
    {
        this.names = new String[this.lines.size() - 1];
        this.x = new int[this.lines.size()-1];
        this.y = new int[this.lines.size()-1];
        this.next1 = new String[this.lines.size() - 1];
        this.next2 = new String[this.lines.size() - 1];
        
        for(int i = 1; i < this.lines.size(); i++)
        {
            String name = "";
            String xS = "";
            String yS = "";
            String next1S = "";
            String next2S ="";
            
            int count = 0;
            
            for(int j=0; j < this.lines.get(i).length(); j++)
            {
                int ascii = (int) this.lines.get(i).charAt(j);
                
                if(ascii == 44)
                {
                    count++;
                }
                
                if(ascii != 44)
                {
                    if(count == 0)
                    {
                        name = name + this.lines.get(i).charAt(j);
                    }
                    
                    if(count == 1)
                    {
                        xS = xS + this.lines.get(i).charAt(j);
                    }
                    
                    if(count == 2)
                    {
                        yS = yS + this.lines.get(i).charAt(j);
                    }
                    
                    if(count == 3)
                    {
                        next1S = next1S + this.lines.get(i).charAt(j);
                    }
                    
                    if(count == 4)
                    {
                        next2S = next2S + this.lines.get(i).charAt(j);
                    }
                }
            }
            
            if(name.equalsIgnoreCase("exit"))
            {
                name = "W";
            }
            
            this.names[i-1] = name;
            this.x[i-1] = Integer.parseInt(xS);
            this.y[i-1] = Integer.parseInt(yS);
            this.next1[i-1] = next1S;
            this.next2[i-1] = next2S;
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void createNodes()
    {
        this.nodes = new Node[this.lines.size() - 1];
        
        for(int i=0; i < this.lines.size() - 1; i++)
        {
            this.nodes[i] = new Node(this.names[i], this.x[i], this.y[i]);
        }
        
        
        int increase = 100;
        
        for(int i=0; i < this.nodes.length; i++)
        {
            this.nodes[i].increaseXY(increase);
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void createEdges()
    {
        this.edges = new ArrayList<>();
        
        for(int i=0; i < this.nodes.length; i++)
        {
            for(int j=0; j < this.nodes.length; j++)
            {
                if(this.next1[i].equalsIgnoreCase(this.nodes[j].getName()))
                {
                    this.edges.add(new Edge(this.nodes[i], this.nodes[j]));
                    this.nodes[i].setNext1(this.nodes[j]);
                }
                    
                if(this.next2[i].equalsIgnoreCase(this.nodes[j].getName()))
                {
                    this.edges.add(new Edge(this.nodes[i], this.nodes[j]));
                    this.nodes[i].setNext2(this.nodes[j]);
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void createMatrix()
    {
        this.matrix = new int[this.nodes.length][this.nodes.length];
        
        for(int i=0; i < this.nodes.length; i++)
        {
            for(int j=0; j < this.nodes.length; j++)
            {
                if(this.nodes[i].next1() != null)
                {
                    if(this.nodes[i].next1().equals(this.nodes[j]))
                    {
                        this.matrix[i][j] = 1;
                    }
                }
                
                if(this.nodes[i].next2() != null)
                {
                    if(this.nodes[i].next2().equals(this.nodes[j]))
                    {
                        this.matrix[i][j] = 1;
                    }
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    public Node[] getNodes()
    {
        return this.nodes;
    }
    
    //--------------------------------------------------------------------------
    
    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }
    
    //--------------------------------------------------------------------------
    
    private void convertPath(String path)
    {
        ArrayList<Integer> intPath = new ArrayList<>();
        
        String value = "";
        
        for(int i=0; i < path.length(); i++)
        {
            int ascii = (int) path.charAt(i);
            
            if(ascii != 44)
            {
                value = value + path.charAt(i);
            }
            
            if((ascii == 44) || (i == (path.length() - 1)))
            {
                intPath.add(Integer.parseInt(value));
                value = "";
            }
        }
        
        for(int i=0; i < intPath.size(); i++)
        {
            for(int j=0; j < this.edges.size(); j++)
            {
                if(i != (intPath.size() - 1))
                {
                    if((this.edges.get(j).getN1().equals(this.nodes[intPath.get(i)])) &&
                            (this.edges.get(j).getN2().equals(this.nodes[intPath.get(i+1)])))
                    {
                        this.edges.get(j).setPath();
                    }
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------
}

