public class DoublyLinkedList<T> {

    private DoublyLink<T> first;
    private DoublyLink<T> last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserta un nodo al principio de la lista, recibe un valor genérico de tipo T
     * 
     * @param d
     */
    public void insertFirst(T d) {
        DoublyLink<T> newLink = new DoublyLink<T>(d);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        size++;
    }

    /**
     * Inserta un nodo al final de la lista, recibe un valor genérico de tipo T
     * 
     * @param d
     */
    public void insertLast(T d) {
        DoublyLink<T> newLink = new DoublyLink<T>(d);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        size++;
    }

    /**
     * Devuelve el primer nodo de la lista sin eliminarlo
     * 
     * @return DoublyLink <T>.
     * @throws EmptyListException
     */
    public DoublyLink<T> peekFirstnode() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        else
            return first;
    }

    /**
     * Devuelve el último nodo de la lista sin eliminarlo
     * 
     * @return DoublyLink <T>.
     * @throws EmptyListException
     */
    public DoublyLink<T> peekLastnode() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        else
            return last;
    }

    /**
     * Método que devuelve el tamaño de la lista
     * 
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserta de manera ordenada ascendente, recibe un valor genérico de tipo T
     * 
     * @param d
     * @throws IllegalArgumentException
     */
    public void insertarOrdenadoAscendente(T d) throws IllegalArgumentException{
        DoublyLink<T> current = first;
        if (isEmpty()) {
            insertFirst(d);
        } else {
            if (d instanceof Double || d instanceof Integer) {
                try {
                    while ((Double) current.getData() < (Double) d) {
                        current = current.next;
                    }
                    if (isFirstNode(current)) {
                        insertFirst(d);
                    } else {
                        insertMiddle(d, current);
                    }

                } catch (Exception NullPointerException) {
                    insertLast(d);
                }
            }
            else{
                throw new IllegalArgumentException("El tipo de dato no es válido para esta operación");
            }
        }
    }


    
    /**
     * Inserta de manera ordenada descendente, recibe un valor genérico de tipo T
     * 
     * @param d
     * @throws IllegalArgumentException
     */ 
    public void insertarOrdenadoDescendente(T d) throws IllegalArgumentException {
        DoublyLink<T> current = first;
        if (isEmpty()) {
            insertFirst(d);
        } else {
            if (d instanceof Double || d instanceof Integer) {
                try {
                    while ((Double) current.getData() < (Double) d) {
                        current = current.next;
                    }
                    if (isFirstNode(current)) {
                        insertFirst(d);
                    } else {
                        insertMiddle(d, current);
                    }

                } catch (Exception NullPointerException) {
                    insertLast(d);
                }
            } else {
                throw new IllegalArgumentException("El tipo de dato no es válido para esta operación");
            }
        }
    }

    /**
     * Supone que la lista tiene al menos dos nodos. Inserta en el medio de ellos
     * 
     * @param d
     * @param current
     */
    public void insertMiddle(T d, DoublyLink<T> current) {
        DoublyLink<T> newLink = new DoublyLink<T>(d);
        newLink.next = current;
        newLink.previous = current.previous;
        current.previous.next = newLink;
        current.previous = newLink;
        size++;
    }

    /**
     * Actualiza el valor de un nodo de la lista, recibe el valor anterior y el
     * nuevo valor
     * 
     * @param previousValue
     * @param newValue
     * @throws ValueNotFoundException
     * @throws EmptyListException
     */
    public void updateNodeWithValue(T previousValue, T newValue) throws ValueNotFoundException, EmptyListException {
        DoublyLink<T> current = first;
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        try {
            while (current.getData() != previousValue) {
                current = current.next;
            }
            current.setData(newValue);
        } catch (NullPointerException e) {
            throw new ValueNotFoundException("El valor no existe en la lista");
        }

    }

    /**
     * Actualiza el valor de un nodo de la lista, recibe la posición a actualizar y
     * el nuevo valor
     * 
     * @param nodePosition
     * @param newValue
     * @throws PositionNotFoundException
     * @throws EmptyListException
     */
    public void updateNodeWithPosition(int nodePosition, T newValue)
            throws PositionNotFoundException, EmptyListException {
        DoublyLink<T> current = first;
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        try {
            for (int i = 0; i < nodePosition; i++) {
                current = current.next;
            }
            current.setData(newValue);
        } catch (NullPointerException e) {
            throw new PositionNotFoundException("La posición no existe en la lista");
        }
    }

    /**
     * Elimina un nodo de la lista, recibe el valor del nodo a eliminar
     * 
     * @param value
     * @return DoublyLink <T>
     * @throws EmptyListException
     * @throws ValueNotFoundException
     */
    public DoublyLink<T> deleteNodeWithValue(T value) throws EmptyListException, ValueNotFoundException {
        DoublyLink<T> current = first;
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        try {
            while (current.getData() != value) {
                current = current.next;
            }
            if (current == first) {
                return deleteFirstNode();
            }
            if (current == last) {
                return deleteLastNode();
            }
            return deleteNodeInTheMiddle(current);
        } catch (NullPointerException e) {
            throw new ValueNotFoundException("El valor no existe en la lista");
        }

    }

    /**
     * Elimina un nodo de la lista, recibe la posición del nodo a eliminar
     * 
     * @param position
     * @throws EmptyListException
     * @throws PositionNotFoundException
     */
    public DoublyLink<T> deleteNodeWithPosition(int position) throws EmptyListException, PositionNotFoundException {
        DoublyLink<T> current = first;
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        try {
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            if (isFirstNode(current)) {
                return deleteFirstNode();
            }
            if (isLastNode(current)) {
                return deleteLastNode();
            }
            return deleteNodeInTheMiddle(current);
        } catch (NullPointerException e) {
            throw new PositionNotFoundException("La posición no existe en la lista");
        }
    }

    /**
     * Borra el primer nodo de la lista
     * 
     * @return DoublyLink <T>
     * @throws EmptyListException
     */
    public DoublyLink<T> deleteFirstNode() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        DoublyLink<T> nodeToDelete = first;
        first = first.next;
        first.previous = null;
        return nodeToDelete;
    }

    /**
     * Borra el último nodo de la lista
     * 
     * @return DoublyLink <T>
     * @throws EmptyListException
     */
    public DoublyLink<T> deleteLastNode() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        DoublyLink<T> nodeToDelete = last;
        last = last.previous;
        last.next = null;
        return nodeToDelete;
    }

    /**
     * Borra un nodo que no sea el primero o el último de la lista
     * 
     * @param node
     * @return DoublyLink <T>
     * @throws EmptyListException
     */
    public DoublyLink<T> deleteNodeInTheMiddle(DoublyLink<T> node) throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("La lista está vacía");
        DoublyLink<T> nodeToDelete = node;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        return nodeToDelete;
    }

    /**
     * Indica si el nodo es el primero de la lista
     * 
     * @param node
     * @return boolean
     */
    public boolean isFirstNode(DoublyLink<T> node) {
        return node == first;
    }

    /**
     * indica si el nodo es el último de la lista
     * 
     * @param node
     * @return boolean
     */
    public boolean isLastNode(DoublyLink<T> node) {
        return node == last;
    }

    /**
     * Limpia la lista
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Devuelve el valor de un nodo de la lista, recibe la posición del nodo
     * 
     * @param index
     * @return valor del nodo
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyLink<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.getData();
    }

    /**
     * Devuelve la posición de un nodo de la lista, recibe el valor del nodo
     * 
     * @param value
     * @return
     */
    public int getPosition(T value) {
        DoublyLink<T> current = first;
        int position = 0;
        try {
            while (current.getData() != value) {
                current = current.next;
                position++;
            }
            return position;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    /**
     * indica si la lista está vacía.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * imprime el contenido de la lista
     */
    public void displayList() {
        DoublyLink<T> current = first;
        if (isEmpty()) {
            System.out.println("la lista está vacía");
        }
        System.out.print("first->");
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.next;
        }
        System.out.println("last");
    }


}
