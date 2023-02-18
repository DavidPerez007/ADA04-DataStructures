/**
 * EmptyListException.java
 * Excepción que se lanza cuando se intenta acceder a un elemento de la lista y está vacía
 */
public class EmptyListException extends Exception{
    public EmptyListException(String message) {
        super(message);
    }
}
