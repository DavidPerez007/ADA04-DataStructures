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
    public DoublyLink<T> next;
    public DoublyLink<T> previous;

    public DoublyLink(T d) {
        this.data = d;
    }

    /**
     * @return the data
     */
    public T getData() {
        return this.data;
    }

    /**
     * Setea el valor del nodo
     * 
     * @param d
     * @return
     */
    public int setData(T d) {
        this.data = d;
        return 1;
    }

}