package griddata;

import java.util.ArrayList;

/**
 * Grid Node of Grid
 * Has 4 neighbors (north, south, east, west)
 * 
 * @author YBZ
 * @version 1.0.0
 */
public class GridNode<T>
{
    // node neighbors in order: north, east, south, west (clockwise starting from north)
    private ArrayList<GridNode<T>> neighbors;

    // value of node
    private T value;

    /**
     * empty constructor creates the node with all empty neighbor values
     * 
     * @since 1.0.0
     */
    public GridNode()
    {
        this.neighbors = new ArrayList<>();
        this.neighbors.add(null); // north
        this.neighbors.add(null); // south
        this.neighbors.add(null); // east
        this.neighbors.add(null); // west
    }

    /**
     * gets value of node
     * 
     * @return value field
     * @since 0.0.1
     */
    public T getValue()
    {
        return this.value;
    }

    /**
     * sets neighbor based on reference
     * 
     * @param node node
     * @param index node position 0,1,2,3 (north, east, south, west) of this node
     * @throws IllegalArgumentException if index is invalid or node is null
     * @since 1.0.0
     */
    public void setNeighbor(GridNode<T> node, int index)
    {
        if (!(index >= 0 && index <=3))
            throw new IllegalArgumentException("invalid index");
        else if (node == null)
            throw new IllegalArgumentException("neighbor node cannot be null");
        this.neighbors.set(index, node);
    }

    /**
     * updates value of this node
     * 
     * @param value new value
     * @return successful
     * @since 1.0.0
     */
    public boolean updateValue(T value)
    {
        try {
            this.value = value;
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * returns the neighbor of index 0,1,2,3 (north, east, south, west respectively)
     *  
     * @param index of neighbor
     * @return neighbor
     * @since 1.0.0
     */
    public GridNode<T> getNeighbor(int index)
    {
        if (!(index >= 0 && index <= 3))
            throw new IllegalArgumentException("invalid index");
        return this.neighbors.get(index);
    }
}
