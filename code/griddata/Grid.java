package griddata;

/**
 * The Grid class is a grid matrix like data structure
 * it consists of a n*n square grid where each grid node has at most 4 neighbors (north, south, east, west)
 * with T as it's data value
 * 
 * @author YBZ
 * @version 0.0.1
 */
public class Grid<T>
{
    // pointer to the current node
    private GridNode<T> currentPosition;

    // number of nodes
    private int size;

    public Grid(int sideLength)
    {
        
    }

    /**
     * moves currentPosition up (north)
     * 
     * @return if move was successful
     * @since 0.0.1
     */
    public boolean moveUp()
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * moves currentPosition right (est)
     * 
     * @return if move was successful
     * @since 0.0.1
     */
    public boolean moveRight()
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * moves currentPosition down (south)
     * 
     * @return if move was successful
     * @since 0.0.1
     */
    public boolean moveDown()
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * moves currentPosition left (west)
     * 
     * @return if move was successful
     * @since 0.0.1
     */
    public boolean moveLeft()
    {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    /**
     * gets the value at the current node
     * 
     * @return value of node
     */
    public T getValue()
    {
        return this.currentPosition.getValue();
    }

    public boolean updateValue(T value)
    {
        return this.currentPosition.updateValue(value);
    }
}
