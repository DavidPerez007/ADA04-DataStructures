/**
 * DoublyLink.java
 * Clase que representa un nodo genérico de una lista doblemente enlazada
 * 
 * @param <T> Tipo de dato que almacena el nodo
 */
class DoublyLink<T> {
    /**
     * El valor que almacena el nodo. Tipo genérico
     */
    private T data;
    private DoublyLink<T> next;
    private DoublyLink<T> previous;

    public DoublyLink(T d) {
        this.data = d;
    }

    /**
     * Obtiene el valor almacenado en el nodo
     * 
     * @return el valor almacenado en el nodo
     */
    public T getData() {
        return this.data;
    }

    /**
     * Establece el valor almacenado en el nodo
     * 
     * @param d el nuevo valor que se desea almacenar en el nodo
     */
    public void setData(T d) {
        this.data = d;
    }

    /**
     * Obtiene el nodo siguiente en la lista
     * 
     * @return el nodo siguiente en la lista
     */
    public DoublyLink<T> getNext() {
        return next;
    }

    /**
     * Establece el nodo siguiente en la lista
     * 
     * @param next el nuevo nodo siguiente en la lista
     */
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior en la lista
     * 
     * @return el nodo anterior en la lista
     */
    public DoublyLink<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el nodo anterior en la lista
     * 
     * @param previous el nuevo nodo anterior en la lista
     */
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
}
