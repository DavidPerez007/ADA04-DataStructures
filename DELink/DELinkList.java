package DELink;

import javax.naming.LinkException;

/**
 * This class represents a simple linked list of generic elements, but this also
 * includes a reference to the last element. It provides various operations
 * to manipulate the list, including adding and removing elements, updating
 * elements, and finding
 * elements. The class includes methods to get the size of the list, clear the
 * list, check if the
 * list is empty, and get the first and last elements of the list. It also
 * includes a static method for casting a generic value to a double. The class
 * uses a Link class to
 * represent individual
 * elements of the list.
 *
 * @param <T> The type of elements in the list.
 */
public class DELinkList<T> {

    private DELink<T> first;
    private DELink<T> last;

    /**
     * Construct method to create an empty linked list.
     */
    public DELinkList() {
        this.first = null;
        this.last = null;
    }

    /**
     * Inserts an element at the beginning of the list.
     * It also updates the reference to the first Link
     * 
     * @param dd the element to insert
     */
    public void insertFirst(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            newLink.setNext(first);
            first = newLink;
        }
    }

    /**
     * Inserts an element at the end of the list.
     * It also updates the reference to the last Link
     * 
     * @param dd the element to insert
     */
    public void insertLast(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty()) {
            insertFirst(dd);
        } else {
            last.setNext(newLink);
            last = newLink;
        }
    }

    /**
     * Inserts a new element in ascending order in the list.
     * When the current node sees the next one is bigger it stops traversing the
     * Linked List and stops and inserts the new node in the current position
     * This method also consider both cases when inserting an element at the
     * beginning
     * or the end of the list.
     * 
     * @param dd the data to insert in the list.
     */
    public void insertIncreasedSorting(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty() || castToDouble(dd) <= castToDouble(first.getData())) {
            insertFirst(dd);
        } else {
            DELink<T> current = first;
            while (current.getNext() != null && castToDouble(current.getNext().getData()) < castToDouble(dd)) {
                current = current.getNext();
            }
            if (current == last) {
                insertLast(dd);
            } else {
                newLink.setNext(current.getNext());
                current.setNext(newLink);
            }
        }
    }

    /**
     * Inserts a new element in ascending order in the list.
     * When the current node sees the next one is smaller it stops traversing the
     * Linked List and stops and inserts the new node in the current position
     * This method also consider both cases when inserting an element at the
     * beginning
     * or the end of the list.
     * 
     * @param dd the data to insert in the list.
     */
    public void insertDecreasedSorting(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty() || castToDouble(dd) >= castToDouble(first.getData())) {
            insertFirst(dd);
        } else {
            DELink<T> current = first;
            while (current.getNext() != null && castToDouble(current.getNext().getData()) > castToDouble(dd)) {
                current = current.getNext();
            }
            if (current == last) {
                insertLast(dd);
            } else {
                newLink.setNext(current.getNext());
                current.setNext(newLink);
            }

        }

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
        DELink<T> currentLink = first;
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
        DELink<T> currentLink = first;
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
     * Deletes the first element in the list that has the given value and returns
     * it. If there are
     * multiple elements with the same value, only the first one is deleted. If no
     * element with the
     * given value is found, a LinkException is thrown.
     * This method considers the case when the Link to delete has the first or last
     * reference, in each
     * case, it is necessary to call another method depending on the task needed,
     * either deleteFirst()
     * or deleteLast()
     * 
     * @param value The value to search for.
     * @return The first element in the list with the given value.
     * @throws LinkException If no element with the given value is found.
     */
    public DELink<T> deleteLinkByValue(T value) throws LinkException {
        DELink<T> currentLink = first;
        DELink<T> previousLink = null;
        if (currentLink.getData() == value && previousLink == null) {
            deleteFirst();
            return currentLink;
        }
        while (currentLink != null) {
            if (currentLink.getData() == value) {
                if (currentLink == last) {
                    deleteLast();
                } else {
                    previousLink.setNext(currentLink.getNext());
                    return currentLink;
                }

            }
            previousLink = currentLink;
            currentLink = currentLink.getNext();
        }
        return previousLink;
    }

    /**
     * Deletes the element at the given position in the list and returns it. The
     * first element in
     * the list is at position 0. If the list does not have the given number of
     * elements, a
     * This method considers the case when the Link to delete has the first or last
     * reference, in each
     * case, it is necessary to call another method depending on the task needed,
     * either deleteFirst()
     * or deleteLast()
     * 
     * @param position The position of the element to delete.
     * @return The element at the given position in the list.
     * @throws LinkException If the list does not have the given number of elements.
     */
    public DELink<T> deleteLinkByPosition(int position) throws LinkException {
        DELink<T> currentLink = first;
        DELink<T> previousLink = null;
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
                if (currentLink == last) {
                    deleteLast();
                }
                previousLink.setNext(currentLink.getNext());
                return currentLink;
            } else {
                throw new LinkException("List overflow, the list has less than " + position + " elements");
            }
        }
        return currentLink;
    }

    /**
     * Deletes the first element of the list.
     * We need to update the new this.first reference to the next Link
     * 
     * @return the element deleted from the list.
     * @throws LinkException if the list is empty.
     */
    public DELink<T> deleteFirst() throws LinkException {
        DELink<T> temp = null;
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
    public DELink<T> deleteLast() throws LinkException {
        DELink<T> currentLink = first;
        DELink<T> previousLink = null;
        if (!isEmpty()) {
            while (currentLink.getNext() != null) {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
            previousLink.setNext(null);
            last = previousLink;
            return currentLink;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

    /**
     * Finds the position of a specific value in the linked list.
     * We need to iterate a current Link to find the value and return its position
     * 
     * @param value the value to find
     * @return the index of the value, or -1 if it is not found
     */
    public int findPosition(T value) {
        DELink<T> current = first;
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
     * Clears the contents of the list by deleting the reference to the first
     * element
     * java garbage collector will do the remaining work
     */
    public void clearList() {
        first = null;
    }

    /**
     * Returns the first link in the list.
     * 
     * @return the first link in the list
     */
    public DELink<T> returnFirstLink() {
        return this.first;
    }

    /**
     * Returns the first link in the list.
     *
     * @return the first link in the list
     */
    public DELink<T> returnLastLink() {
        return this.last;
    }

    /**
     * Returns the number of links in the list
     * It is done iterating each Link in the List.
     * 
     * @return the number of links in the list
     */
    public int getSize() {
        DELink<T> currentLink = first;
        int counter = 0;
        while (currentLink != null) {
            counter++;
            currentLink = currentLink.getNext();
        }
        return counter;
    }

    /**
     * Displays the contents of the linked list.
     */
    public void displayList() {
        System.out.print("List (first--> ");
        DELink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
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
     * Depending on the case, it will cast from a String or a Double (and child
     * classes) objects to a double datatype
     *
     * @param value the value to convert
     * @return the value as a double
     * @throws IllegalArgumentException if the value cannot be converted to a double
     */
    public static <T> double castToDouble(T value) {
        if (value instanceof Double) {
            return (double) value;
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            throw new IllegalArgumentException("El valor no se puede convertir a double");
        }
    }
}
