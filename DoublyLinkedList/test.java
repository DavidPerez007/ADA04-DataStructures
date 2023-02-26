public class test {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        //debe imprimir "La lista está vacía"
        System.out.println("debe imprimir \"La lista está vacía\"");
        list.displayList();
        System.out.println("-----------------------------");

        // inserta 1 nodo al inicio de la lista
        System.out.println("inserta 1 nodo al inicio de la lista");
        list.insertFirst(7);
        list.displayList();
        System.out.println("-----------------------------");

        //inserta 5 nodos al principio de la lista
        System.out.println("inserta 5 nodos al principio de la lista");
        for (int i = 0; i < 5; i++) {
            list.insertFirst(i);
        }
        list.displayList();
        System.out.println("-----------------------------");

        // inserta 5 nodos al final de la lista
        System.out.println("inserta 5 nodos al final de la lista");
        for (int i = 1; i < 6; i++) {
            list.insertLast(i * 10);
        }
        list.displayList();
        System.out.println("-----------------------------");

        //verificar tamaño de la lista
        System.out.println("verificar tamaño de la lista");
        System.out.println("El tamaño de la lista es: " + list.getSize());
        System.out.println("-----------------------------");

        // actualizar el valor del nodo con valor actual 7
        System.out.println("actualizar el valor del nodo con valor actual 7");
        try {
            list.updateNodeWithValue(7, 77);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // actualizar un valor que no existe en la lista
        System.out.println("actualizar un valor que no existe en la lista");
        try {
            list.updateNodeWithValue(777, 7777);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // actualizar el valor del nodo con posición 3
        System.out.println("actualizar el valor del nodo con posición 3");
        try {
            list.updateNodeWithPosition(3, 333);
        } catch (PositionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // actualizar una posición que no existe en la lista
        System.out.println("actualizar una posición que no existe en la lista");
        try {
            list.updateNodeWithPosition(33, 3333);
        } catch (PositionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // eliminar nodo por valor
        System.out.println("eliminar nodo por valor");
        try {
            list.deleteNodeWithValue(77);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // eliminar nodo con un valor que no existe en la lista
        System.out.println("eliminar nodo con un valor que no existe en la lista");
        try {
            list.deleteNodeWithValue(3333);
        } catch (ValueNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // elimina un nodo dada su posición
        System.out.println("elimina un nodo dada su posición");
        try {
            list.deleteNodeWithPosition(3);
        } catch (PositionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // limpia la lista
        list.clear();
        list.displayList();
        System.out.println("-----------------------------");

        // inserta 2 nodos al inicio de la lista
        System.out.println("inserta 2 nodos al inicio de la lista");
        for (int i = 1; i < 3; i++) {
            list.insertFirst(i);
        }
        list.displayList();
        System.out.println("-----------------------------");

        // elimina el primer nodo
        System.out.println("elimina el primer nodo");
        try {
            list.deleteNodeWithPosition(0);
        } catch (PositionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // insertamos otro valor al inicio
        System.out.println("insertamos otro valor al inicio");
        list.insertFirst(5);
        list.displayList();
        System.out.println("-----------------------------");

        // eliminar el ultimo nodo
        try {
            list.deleteNodeWithPosition(list.getSize() - 1);
        } catch (PositionNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        list.displayList();
        System.out.println("-----------------------------");

        // insertar 5 elementos en la lista al principio
        System.out.println("insertar 5 elementos en la lista al principio");
        for (int i = 0; i < 5; i++) {
            list.insertFirst(i);
        }
        list.displayList();
        System.out.println("-----------------------------");

        // obtener la posición del elemento 0, debe ser 4
        System.out.println("obtener la posición del elemento 0, debe ser 4");
        System.out.println("La posición del elemento 0 es: " + list.getPosition(0));
        System.out.println("obtener la posición del elemento 3 debe ser 1");
        System.out.println("La posición del elemento 3 es: " + list.getPosition(3));
        System.out.println("-----------------------------");

        // limpiar la list
        System.out.println("limpiar la lista");
        list.clear();
        list.displayList();
        System.out.println("-----------------------------");

        try {
            // insertar 1 valor en la lista ascendente
            System.out.println("insertar 1 valor en la lista ascendente");
            list.insertarOrdenadoAscendente(3);
            list.displayList();
            System.out.println("-----------------------------");

            // insertar 1 valor en la lista ascendente
            System.out.println("insertar 1 valor en la lista ascendente");
            list.insertarOrdenadoAscendente(40);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista ascendente
            System.out.println("insertar 1 valor en la lista ascendente");
            list.insertarOrdenadoAscendente(9);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista ascendente
            System.out.println("insertar 1 valor en la lista ascendente");
            list.insertarOrdenadoAscendente(1);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista ascendente
            System.out.println("insertar 1 valor en la lista ascendente");
            list.insertarOrdenadoAscendente(700);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoAscendente(58);
            list.displayList();
            System.out.println("-----------------------------");
            // imprime el tamaño de la lista
            System.out.println("El tamaño de la lista es: " + list.getSize());
            // limpiar la lista
            System.out.println("limpiar la lista");
            list.clear();
            list.displayList();
            System.out.println("-----------------------------");

            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(3);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(40);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(9);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(1);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(700);
            list.displayList();
            System.out.println("-----------------------------");
            // insertar 1 valor en la lista descendente
            System.out.println("insertar 1 valor en la lista descendente");
            list.insertarOrdenadoDescendente(58);
            list.displayList();
            System.out.println("-----------------------------");
            System.out.println("El tamaño de la lista es: " + list.getSize());

            // limpiar la lista
            System.out.println("limpiar la lista");
            list.clear();
            list.displayList();
            System.out.println("-----------------------------");

            // alternando asc y desc
            System.out.println("alternando asc y desc");
            list.insertarOrdenadoAscendente(3);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoDescendente(40);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoAscendente(9);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoDescendente(1);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoAscendente(700);
            list.displayList();
            System.out.println("-----------------------------");
            list.insertarOrdenadoDescendente(58);
            list.displayList();
            System.out.println("-----------------------------");
            System.out.println("El tamaño de la lista es: " + list.getSize());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    
    }
}
