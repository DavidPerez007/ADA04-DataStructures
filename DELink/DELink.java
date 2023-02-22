package DELink;

/**
 * A class that represents a linked node.
 * It contains a reference next node, as well as a data to store
 * element.
 * 
 * @param <T> the type of the data element
 */
public class DELink<T> {
    private T dData;
    private DELink<T> next;

    /**
     * Construct method that creates a new DELink object with the given data.
     * 
     * @param dd the data to be stored in the node
     */
    public DELink(T dd) {
        dData = dd;
    }

    /**
     * Displays the data element stored in this node.
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    /**
     * Sets the data element stored in this node to the given value.
     * 
     * @param data the new data element
     */
    public void setData(T data) {
        this.dData = data;
    }

    /**
     * Returns the data element stored in this node.
     * 
     * @return the data element
     */
    public T getData() {
        return this.dData;
    }

    /**
     * Sets the next node in the list to the current node.
     * 
     * @param next the new next node
     */
    public void setNext(DELink<T> next) {
        this.next = next;
    }

    /**
     * Returns the next node in the list.
     * 
     * @return the next node
     */
    public DELink<T> getNext() {
        return this.next;
    }
}
