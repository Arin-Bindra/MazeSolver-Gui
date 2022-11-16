import java.util.ArrayList;

/**
 * Arin Bindra
 * 
 */

public class PathFinder {
    
    int[][] adjacencyMatrix;
    String path;
    ArrayList<Integer> queue;
    String visited;
    int[] lastNode;
    
    public PathFinder(int[][] matrix)
    {
        this.adjacencyMatrix = matrix;
        this.lastNode = new int[matrix.length];
        
        for(int i=0; i < this.lastNode.length; i++)
        {
            this.lastNode[i] = -1;
        }
        
        this.queue = new ArrayList<>();
        this.visited = "";
        this.path = "";
    }
    
    //--------------------------------------------------------------------------
    
    private void enqueue(int node)
    {
        this.queue.add(node);
    }
    
    //--------------------------------------------------------------------------
    
    private int dequeue()
    {
        int node = this.queue.get(0);
        this.queue.remove(0);
        return node;
    }
    
    //--------------------------------------------------------------------------
    
    private boolean isQueueEmpty()
    {
        return this.queue.isEmpty();
    }
    
    //--------------------------------------------------------------------------
    
    //implement the findPath() method here
    //so the method returns a String of shortest path from the start to the end
    
    public String findPath(int start, int end)
    {
        this.enqueue(start);
        this.visited = start + " ";
        
        while(this.queue.isEmpty() != true)
        {
            int current = this.dequeue();
            
            for(int i=0; i < this.adjacencyMatrix[current].length; i++)
            {
                //whether the path table needs to be updated
                if(this.adjacencyMatrix[current][i] != 0)
                {
                    //whether the node i has been visted( enqueue i, add i to visted, update i's path/last node)
                    if(!this.visited.contains(i+" "))
                    {
                        this.enqueue(i);
                        //add node to visted list
                        
                        this.visited += i + " ";
                        
                        lastNode[i] = current;
                    }
                }
            
            }
        }
        
        //use the path table to generate the path from start to the end
        
        String path = "";
        
        for(int i = end; lastNode[i] >= 0; i = lastNode[i])
        {
            path = i + "," + path;
        }
        
        path = start + "," + path;
        
        return path;
    }
}
