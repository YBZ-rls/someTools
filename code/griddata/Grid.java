package griddata;

import java.util.ArrayList;

/**
 * The Grid class is a grid matrix like data structure
 * it consists of a n*n square grid where each grid node has at most 4 neighbors (north, south, east, west)
 * with T as it's data value
 * 
 * You can in turn change T to be of any Object value
 * 
 * @author YBZ
 * @version 1.0.0
 */
public class Grid<T>
{
    // pointer to the current node
    private GridNode<T> currentNode;

    // column, row coordinate of node (starting from top left)
    private int[] position;

    // number of nodes
    private final int SIZE;

    /**
     * creates a grid based on side length
     * side length is sqrt(size)
     * 
     * @param sideLength
     * @param columnPosition starting column position
     * @param rowPosition starting row position
     * @throws IllegalArgumentException if side length is >= 0 or if row or col positions are invalid
     * @since 1.0.0
     */
    public Grid(int sideLength, int columnPosition, int rowPosition)
    {
        if (sideLength <= 0)
            throw new IllegalArgumentException("Side length must be a possitive number");
        else if (columnPosition > sideLength || rowPosition > sideLength || columnPosition <= 0 || rowPosition <= 0)
            throw new IllegalArgumentException("Invalid row or column position cannot be largeer than side length");

        this.SIZE = sideLength * sideLength;
        ArrayList<ArrayList<GridNode<T>>> rows = new ArrayList<>();
        for (int t = 0; t < sideLength; t++)
        {
            ArrayList<GridNode<T>> row = new ArrayList<>();
            for (int i = 0; i < sideLength; i++)
            {
                GridNode<T> cur = new GridNode<>();
                if (i != 0)
                {
                    cur.setNeighbor(row.get(i-1), 3);
                    row.get(i-1).setNeighbor(cur, 1);
                }
                if (t != 0)
                {
                    cur.setNeighbor(rows.get(t-1).get(i), 0);
                    rows.get(t-1).get(i).setNeighbor(cur, 2);
                }
                row.add(cur);
            }
            rows.add(row);
        }
        this.currentNode = rows.get(rowPosition-1).get(columnPosition-1);
        this.position = new int[]{columnPosition, rowPosition};
    }

    /** 
     * @param sideLength
     * @since 1.0.0
     */
    public Grid(int sideLength)
    {
        // starts current position at top left
        this(sideLength, 1, 1);
    }

    /**
     * moves currentPosition up (north)
     * 
     * @return if move was successful
     * @since 1.0.0
     */
    public boolean moveUp() { return moveTo(0); }

    /**
     * moves currentPosition right (est)
     * 
     * @return if move was successful
     * @since 1.0.0
     */
    public boolean moveRight() { return moveTo(1); }

    /**
     * moves currentPosition down (south)
     * 
     * @return if move was successful
     * @since 1.0.0
     */
    public boolean moveDown() { return moveTo(2); }

    /**
     * moves currentPosition left (west)
     * 
     * @return if move was successful
     * @since 1.0.0
     */
    public boolean moveLeft() { return moveTo(3); }

    
    private boolean moveTo(int index)
    {
        if (this.currentNode.getNeighbor(index) == null)
            return false;
        this.currentNode = this.currentNode.getNeighbor(index);
        switch (index)
        {
            case 0 -> this.position[1]--;
            case 1 -> this.position[0]++;
            case 2 -> this.position[1]++;
            case 3 -> this.position[0]--;
        }
        return true;
    }

    /**
     * gets number of nodes in grid (size)
     * 
     * @return size field
     * @since 1.0.0
     */
    public int size()
    {
        return this.SIZE;
    }

    /**
     * gets the value at the current node
     * 
     * @return value of node
     * @since 0.0.1
     */
    public T getValue()
    {
        return this.currentNode.getValue();
    }

    /**
     * updates the value of the current node
     * 
     * @param value
     * @return if update is successful
     * @since 1.0.0
     */
    public boolean updateValue(T value)
    {
        return this.currentNode.updateValue(value);
    }

    /**
     * get the current position of the node in grid
     * e.g. [3,4] (3rd column, 4th row counting from top left)
     * 
     * @return int array of position x, y
     * @since 1.0.0
     */
    public int[] getPosition()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * toString override
     * 
     * @since 1.0.0
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Position (X,Y): (%s, %s)\n", this.position[0], this.position[1]));
        builder.append("Value: \n");
        builder.append(this.currentNode.getValue());

        return builder.toString();
    }
}
