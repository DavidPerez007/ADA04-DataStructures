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

    public Link deleteFirst() {
        Link temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
        }
        return temp;
    }

    public Link deleteLast() {
        Link currentLink = first;
        Link previousLink = null;
        while (currentLink.getNext() != null) {
            previousLink = currentLink;
            currentLink = currentLink.getNext();
        }
        previousLink.setNext(null);
        return currentLink;
    }

    public Link deleteLink(double value) {
        Link currentLink = first;
        while (currentLink.getNext() != null) {
            if (currentLink.getNext().getData() == value) {
                Link nodeToDelete = currentLink.getNext();
                currentLink.setNext(currentLink.getNext().getNext());
                return nodeToDelete;
            }
            currentLink = currentLink.getNext();
        }
        return null;
    }

    public Link findLink(double value) {
        Link current = first;
        while (current != null) {
            if (current.getData() == value) {
                return current;
            }
            current = current.getNext();
        }
        return null;
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

    public double getElementAt(int position) {
        Link current = first;
        int counter = 0;
        while (current != null) {
            if(counter == position){
                return current.getData();
            }
            counter++;
            current = current.getNext();
        }
        return -1;
    }

    public Link returnFirstLink(){
        return this.first;
    }

    public Link returnLastLink(){
        Link current = first;
        while(current != null){
            current = current.getNext();
        }
        return current;
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
