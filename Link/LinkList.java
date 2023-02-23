/**
 * This class represents a singly linked list of generic elements. It provides
 * various operations
 * to manipulate the list, including adding and removing elements, updating
 * elements, and finding
 * elements. The class includes methods to get the size of the list, clear the
 * list, check if the
 * list is empty, and get the first and last elements of the list. It also
 * includes a static method for casting a generic value to a double. The class uses a Link class to
 * represent individual
 * elements of the list.
 *
 * @param <T> The type of elements in the list.
 */
class LinkList<T> {
    private Link<T> first;

    /**
     * Constructor of the class.
     * Initializes the 'first' attribute as null.
     */
    public LinkList() {
        first = null;
    }

    /**
     * Inserts a new element at the beginning of the list.
     * 
     * @param dd the data to insert in the list.
     */
    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * Inserts a new element at the end of the list.
     * 
     * @param dd the data to insert in the list.
     */
    public void insertLast(T dd) {
        Link<T> newLink = new Link<T>(dd);
        Link<T> currentLink = first;
        Link<T> previousLink = null;
        if (isEmpty()) {
            insertFirst(dd);
        } else {
            while (currentLink != null) {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
            previousLink.setNext(newLink);
            newLink.setNext(null);
        }
    }

    /**
     * Inserts a new element in ascending order in the list.
     * When the current node sees the next one is bigger it stops traversing the
     * Linked List and stops and inserts the new node in the current position
     * 
     * @param dd the data to insert in the list.
     */
    public void insertIncreasedSorting(T dd) {
        Link<T> newLink = new Link<T>(dd);
        Link<T> current = first;
        Link<T> previous = null;
        try {
            if (isEmpty() || castValue(current.getData()) > castValue(dd)) {
                insertFirst(dd);
            } else {
                while (current != null && castValue(current.getData()) < castValue(dd)) {
                    previous = current;
                    current = current.getNext();
                }
                previous.setNext(newLink);
                newLink.setNext(current);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * Inserts a new element in descending order in the list.
     * When the current node sees the next one is smaller it stops traversing the
     * Linked List and stops and inserts the new node in the current position
     * 
     * @param dd the data to insert in the list.
     */
    public void insertDecreasedSorting(T dd) {
        Link<T> newLink = new Link<T>(dd);
        Link<T> current = first;
        Link<T> previous = null;
        try {
            if (isEmpty() || castValue(current.getData()) < castValue(dd)) {
                insertFirst(dd);
            } else {
                while (current != null && castValue(current.getData()) > castValue(dd)) {
                    previous = current;
                    current = current.getNext();
                }
                previous.setNext(newLink);
                newLink.setNext(current);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the first element of the list.
     * We need to update the new this.first reference to the next Link
     * 
     * @return the element deleted from the list.
     * @throws LinkException if the list is empty.
     */
    public Link<T> deleteFirst() throws LinkException {
        Link<T> temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            return temp;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

    /**
     * Deletes the last element in the list and returns it.
     * 
     * @return The last element in the list.
     * @throws LinkException If the list is empty.
     */
    public Link<T> deleteLast() throws LinkException {
        Link<T> currentLink = first;
        Link<T> previousLink = null;
        if (!isEmpty()) {
            while (currentLink.getNext() != null) {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
            previousLink.setNext(null);
            return currentLink;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

    /**
     * Deletes the first element in the list that has the given value and returns
     * it. If there are
     * multiple elements with the same value, only the first one is deleted. If no
     * element with the
     * given value is found, a LinkException is thrown.
     * 
     * @param value The value to search for.
     * @return The first element in the list with the given value.
     * @throws LinkException If no element with the given value is found.
     */
    public Link<T> deleteLinkByValue(T value) throws LinkException {
        Link<T> currentLink = first;
        Link<T> previousLink = null;
        while (currentLink != null) {
            if (currentLink.getData() == value && previousLink == null) {
                deleteFirst();
                return currentLink;
            } else {
                if (currentLink.getData() == value) {
                    previousLink.setNext(currentLink.getNext());
                    return currentLink;
                }
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
        }
        throw new LinkException("Error 404: there is no node with " + value + " value, couldnt update");
    }

    /**
     * Deletes the element at the given position in the list and returns it. The
     * first element in
     * the list is at position 0. If the list does not have the given number of
     * elements, a
     * LinkException is thrown.
     * 
     * @param position The position of the element to delete.
     * @return The element at the given position in the list.
     * @throws LinkException If the list does not have the given number of elements.
     */
    public Link<T> deleteLinkByPosition(int position) throws LinkException {
        Link<T> currentLink = first;
        Link<T> previousLink = null;
        int counter = 0;
        if (position == 0) {
            deleteFirst();
        } else {
            while (currentLink != null && counter < position) {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
                counter++;
            }
            if (counter == position && currentLink != null) {
                previousLink.setNext(currentLink.getNext());
                return currentLink;
            }
        }
        throw new LinkException("List overflow, the list has less than " + position + " elements");
    }

    /**
     * Updates the first element in the list that has the old value with the new
     * value.
     * If there is no element with the old value, a LinkException is thrown.
     * 
     * @param oldValue The old value to search for.
     * @param newValue The new value to replace the old value with.
     * @throws LinkException If no element with the given old value is found.
     */
    public void updateLinkByValue(T oldValue, T newValue) throws LinkException {
        Link<T> currentLink = first;
        while (currentLink != null) {
            if (currentLink.getData() == oldValue) {
                currentLink.setData(newValue);
            } else {
                currentLink = currentLink.getNext();
            }
        }
        throw new LinkException("Error 404: node not found, couldnt update");
    }

    /**
     * Updates the element at the given position in the list with the new value. The
     * first
     * element in the list is at position 0. If the list does not have the given
     * number of elements,
     * a LinkException is thrown.
     * 
     * @param position The position of the element to update.
     * @param newValue The new value to replace the old value with.
     * @throws LinkException If the list does not have the given number of elements.
     */
    public void updateLinkByPosition(int position, T newValue) throws LinkException {
        Link<T> currentLink = first;
        int counter = 0;
        while (currentLink != null) {
            if (counter == position) {
                currentLink.setData(newValue);
            } else {
                currentLink = currentLink.getNext();
                counter++;
            }
        }
        throw new LinkException("List overflow, the list has less than " + position + " elements");

    }

    /**
     * Finds the position of a specific value in the linked list.
     * We need to iterate a current Link to find the value and return its position
     * 
     * @param value the value to find
     * @return the index of the value, or -1 if it is not found
     */
    public int findPosition(T value) {
        Link<T> current = first;
        int counter = 0;
        if (isEmpty()) {
            return -1;
        } else {
            while (current != null) {
                if (current.getData() == value) {
                    return counter;
                }
                current = current.getNext();
                counter++;
            }
        }
        return -1;
    }

    /**
     * Displays the contents of the linked list.
     */
    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

    /**
     * Returns the number of links in the list
     * It is done iterating each Link in the List.
     * 
     * @return the number of links in the list
     */
    public int getSize() {
        Link<T> currentLink = first;
        int counter = 0;
        while (currentLink != null) {
            counter++;
            currentLink = currentLink.getNext();
        }
        return counter;
    }

    /**
     * Clears the contents of the list by deleting the reference to the first
     * element
     * java garbage collector will do the remaining work
     */
    public void clearList() {
        first = null;
    }

    /**
     * Returns the data stored in the link at the specified position.
     * 
     * @param position the position of the link to be retrieved
     * @return the data stored in the link at the specified position
     * @throws LinkException if the list does not contain the specified number of
     *                       links
     */
    public T getElementAt(int position) throws LinkException {
        Link<T> current = first;
        int counter = 0;
        while (current != null) {
            if (counter == position) {
                return current.getData();
            }
            counter++;
            current = current.getNext();
        }
        throw new LinkException("List overflow, the list has less than " + position + " elements");
    }

    /**
     * Returns the first link in the list.
     * 
     * @return the first link in the list
     */
    public Link<T> returnFirstLink() {
        return this.first;
    }

    /**
     * Returns the first link in the list.
     *
     * @return the first link in the list
     */
    public Link<T> returnLastLink() {
        Link<T> current = first;
        while (current != null) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return (first == null);
    }


/**
 * Converts a value of type T to a double.
 * Depending on the case, it will cast from a String or a Double (and child classes) objects to a double datatype
 *
 * @param value the value to convert
 * @return the value as a double
 * @throws IllegalArgumentException if the value cannot be converted to a double
 */
    public static double castValue(Object value) throws IllegalArgumentException {
        if (value instanceof Double) {
            return (double) value;
        } else if (value instanceof Float) {
            return (double) (float) value;
        } else if (value instanceof Integer) {
            return (double) (int) value;
        } else if (value instanceof Long) {
            return (double) (long) value;
        } else if (value instanceof Short) {
            return (double) (short) value;
        } else if (value instanceof Byte) {
            return (double) (byte) value;
        } else if (value instanceof Character) {
            return (double) (char) value;
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            throw new IllegalArgumentException("El valor no se puede convertir a double");
        }
    }

}
