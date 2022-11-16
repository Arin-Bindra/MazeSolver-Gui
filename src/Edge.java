/**
 * Arin Bindra
 *
 */

public class Edge {
    
    private Node n1;
    private Node n2;
    private boolean path = false;
    
    public Edge(Node n1, Node n2)
    {
        this.setN1(n1);
        this.setN2(n2);
    }
    
    //--------------------------------------------------------------------------
    
    private void setN1(Node n1)
    {
        this.n1 = n1;
    }
    
    //--------------------------------------------------------------------------
    
    private void setN2(Node n2)
    {
        this.n2 = n2;
    }
    
    //--------------------------------------------------------------------------
    
    public void setPath()
    {
        this.path = true;
    }
    
    //--------------------------------------------------------------------------
    
    public Boolean getPath()
    {
        return this.path;
    }
    
    //--------------------------------------------------------------------------
    
    public Node getN1()
    {
        return this.n1;
    }
    
    //--------------------------------------------------------------------------
    
    public Node getN2()
    {
        return this.n2;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public String toString()
    {
        return "" + this.n1 + " " + this.path + " " + this.n2;
    }
}
