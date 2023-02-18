package DELink;

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
