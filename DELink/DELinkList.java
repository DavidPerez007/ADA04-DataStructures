package DELink;

import javax.naming.LinkException;

public class DELinkList<T> {

    private DELink<T> first;
    private DELink<T> last;

    public DELinkList() {
        this.first = null;
        this.last = null;
    }

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

    public void insertLast(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty()) {
            insertFirst(dd);
        } else {
            last.setNext(newLink);
            last = newLink;
        }
    }

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
                if(currentLink == last){
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

    public DELink<T> deleteFirst() throws LinkException {
        DELink<T> temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            return temp;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

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

    public void clearList() {
        first = null;
    }

    public DELink<T> returnFirstLink() {
        return this.first;
    }

    public DELink<T> returnLastLink() {
        return this.last;
    }

    public int getSize() {
        DELink<T> currentLink = first;
        int counter = 0;
        while (currentLink != null) {
            counter++;
            currentLink = currentLink.getNext();
        }
        return counter;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        DELink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

    public boolean isEmpty() {
        return (first == null);
    }

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
