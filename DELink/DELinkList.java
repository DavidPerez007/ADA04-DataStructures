package DELink;

public class DELinkList<T> {
    
    private DELink<T> first;
    private DELink<T> last;

    public DELinkList(){
        this.first = null;
        this.last = null;
    }

    public void insertFirst(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        newLink.setNext(first);
        first = newLink;
        last = newLink;
    }

     public void insertLast(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty()) {
            insertFirst(dd);
        } else {
            last.setNext(newLink);
            newLink = last;
        }
    }
    // public void insertIncreasedSorting(double dd) {
    //     DELink<T> newLink = new DELink(dd);
    //     DELink<T> current = first;
    //     DELink<T> previous = null;
    //     if (isEmpty() || current.getData() > dd) {
    //         insertFirst(dd);
    //     } else {
    //         while (current != null && current.getData() < dd) {
    //             previous = current;
    //             current = current.getNext();
    //         }
    //         previous.setNext(newLink);
    //         newLink.setNext(current);
    //     }

    // }

    // public void insertDecreasedSorting(double dd) {
    //     DELink<T> newLink = new DELink(dd);
    //     DELink<T> current = first;
    //     DELink<T> previous = null;
    //     if (isEmpty() || current.getData() < dd) {
    //         insertFirst(dd);
    //     } else {
    //         while (current != null && current.getData() > dd) {
    //             previous = current;
    //             current = current.getNext();
    //         }
    //         previous.setNext(newLink);
    //         newLink.setNext(current);
    //     }
    // }


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

    public boolean isEmpty() {
        return (first == null);
    }
}
