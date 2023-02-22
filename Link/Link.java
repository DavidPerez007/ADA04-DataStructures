/**
 * Class that represents a node in a singly linked list.
 * @param <T> the type of data stored in the node
 */
public class Link<T> {
    private T dData;
    private Link<T> next; 

    /**
     * Constructs a new node with the given data.
     * @param dd the data to be stored in the node
     */
    public Link(T dd) {
        dData = dd;
    }

     /**
     * Prints the data stored in the node.
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    /**
     * Sets the data stored in the node.
     * @param data the new data to be stored in the node
     */
    public void setData(T data){
        this.dData = data;
    }

    /**
     * Returns the data stored in the node.
     * @return the data stored in the node
     */
    public T getData(){
        return this.dData;
    }

    /**
     * Sets the next node in the linked list.
     * @param next the next node in the linked list
     */
    public void setNext(Link<T> next){
        this.next = next;
    }
    
    /**
     * Returns the next node in the linked list.
     * @return the next node in the linked list
     */
    public Link<T> getNext(){
        return this.next;
    }
}