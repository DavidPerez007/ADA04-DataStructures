class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(double dd) {
        Link newLink = new Link(dd);
        Link currentLink = first;
        Link previousLink = null;
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

    public void insertIncreasedSorting(double dd) {
        Link newLink = new Link(dd);
        Link current = first;
        Link previous = null;
        if (isEmpty() || current.getData() > dd) {
            insertFirst(dd);
        } else {
            while (current != null && current.getData() < dd) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newLink);
            newLink.setNext(current);
        }

    }

    public void insertDecreasedSorting(double dd) {
        Link newLink = new Link(dd);
        Link current = first;
        Link previous = null;
        if (isEmpty() || current.getData() < dd) {
            insertFirst(dd);
        } else {
            while (current != null && current.getData() > dd) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    public Link deleteFirst() throws LinkException {
        Link temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            return temp;
        }
        throw new LinkException("Couldnt delete, the list is empty");
    }

    public Link deleteLast() throws LinkException {
        Link currentLink = first;
        Link previousLink = null;
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

    public Link deleteLinkByValue(double value) throws LinkException {
        Link currentLink = first;
        Link previousLink = null;
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

    public Link deleteLinkByPosition(int position) throws LinkException {
        Link currentLink = first;
        Link previousLink = null;
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

    public void updateLinkByValue(double oldValue, double newValue) throws LinkException {
        Link currentLink = first;
        while (currentLink != null) {
            if (currentLink.getData() == oldValue) {
                currentLink.setData(newValue);
            } else {
                currentLink = currentLink.getNext();
            }
        }
        throw new LinkException("Error 404: node not found, couldnt update");
    }

    public void updateLinkByPosition(int position, double newValue) throws LinkException {
        Link currentLink = first;
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

    public Link findLink(double value) throws LinkException {
        Link current = first;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.getNext();
        }
        throw new LinkException("Error 404: node not found");
    }

    public int findPosition(double value) {
        Link current = first;
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
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

    public int getSize() {
        Link currentLink = first;
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

    public double getElementAt(int position) throws LinkException {
        Link current = first;
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

    public Link returnFirstLink() {
        return this.first;
    }

    public Link returnLastLink() {
        Link current = first;
        while (current != null) {
            current = current.getNext();
        }
        return current;
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
