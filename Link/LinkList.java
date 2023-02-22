class LinkList<T>{
    private Link<T> first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        newLink.setNext(first);
        first = newLink;
    }

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

    public void insertIncreasedSorting(T dd) {
        Link<T> newLink = new Link<T>(dd);
        Link<T> current = first;
        Link<T> previous = null;
        try {
            if (isEmpty() || castToDouble(current.getData()) > castToDouble(dd)) {
                insertFirst(dd);
            } else {
                while (current != null && castToDouble(current.getData()) < castToDouble(dd)) {
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

    public void insertDecreasedSorting(T dd) {
        Link<T> newLink = new Link<T>(dd);
        Link<T> current = first;
        Link<T> previous = null;
        try {
            if (isEmpty() || castToDouble(current.getData()) < castToDouble(dd)) {
                insertFirst(dd);
            } else {
                while (current != null && castToDouble(current.getData()) > castToDouble(dd)) {
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

    public Link<T> deleteFirst() throws LinkException {
        Link<T> temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            return temp;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

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

    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

    public int getSize() {
        Link<T> currentLink = first;
        int counter = 0;
        while (currentLink != null) {
            counter++;
            currentLink = currentLink.getNext();
        }
        return counter;
    }

    public void clearList() {
        first = null;
    }

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

    public Link<T> returnFirstLink() {
        return this.first;
    }

    public Link<T> returnLastLink() {
        Link<T> current = first;
        while (current != null) {
            current = current.getNext();
        }
        return current;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public static <T> double castToDouble(T value) throws IllegalArgumentException {
        if (value instanceof Double) {
            return (double) value;
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            throw new IllegalArgumentException("El valor no se puede convertir a double");
        }
    }
    
    
}
