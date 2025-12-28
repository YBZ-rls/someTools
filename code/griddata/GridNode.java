package griddata;

/**
 * Grid Node of Grid
 * Has 4 neighbors (north, south, east, west)
 * 
 * @author YBZ
 * @version 0.0.1
 */
public class GridNode<T>
{
    // node neighbors in order: north, east, south, west (clockwise starting from north)
    private GridNode<T>[] neighbors;

    // value of node
    private T value;

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
     * updates value of this node
     * 
     * @param value new value
     * @return successful
     * @since 0.0.1
     */
    public boolean updateValue(T value)
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * returns the neighbor of index 0,1,2,3 (north, east, south, west respectively)
     *  
     * @param index of neighbor
     * @return neighbor
     */
    public GridNode<T> getNeighbor(int index)
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
}
