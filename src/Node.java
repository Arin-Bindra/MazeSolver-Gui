/**
 * Arin Bindra
 *
 */

public class Node {
    
    private String name;
    private int x;
    private int y;
    private Node next1 = null;
    private Node next2 = null;
    
    public Node(String name, int x, int y)
    {
        this.setName(name);
        this.setX(x);
        this.setY(y);
    }
    
    //--------------------------------------------------------------------------
    
    private void setName(String name)
    {
        this.name = name;
    }
    
    //--------------------------------------------------------------------------
    
    private void setX(int x)
    {
        this.x = x;
    }
    
    //--------------------------------------------------------------------------
    
    private void setY(int y)
    {
        this.y = y;
    }
    
    //--------------------------------------------------------------------------
    
    public void setNext1(Node next1)
    {
        this.next1 = next1;
    }
    
    //--------------------------------------------------------------------------
    
    public void setNext2(Node next2)
    {
        this.next2 = next2;
    }
    
    //--------------------------------------------------------------------------
    
    public String getName()
    {
        return this.name;
    }
    
    //--------------------------------------------------------------------------
    
    public int getX()
    {
        return this.x;
    }
    
    //--------------------------------------------------------------------------
    
    public int getY()
    {
        return this.y;
    }
    
    //--------------------------------------------------------------------------
    
    public void increaseXY(int i)
    {
        this.x = this.x * i;
        this.y = this.y * i;
    }
    
    //--------------------------------------------------------------------------
    
    public Node next1()
    {
        return this.next1;
    }
    
    //--------------------------------------------------------------------------
    
    public Node next2()
    {
        return this.next2;
    }
    
    //--------------------------------------------------------------------------
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
