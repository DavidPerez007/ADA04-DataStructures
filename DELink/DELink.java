package DELink;

public class DELink<T>{
    private T dData;
    private DELink<T> next;

    public DELink(T dd) {
            dData = dd;
        }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    public void setData(T data) {
        this.dData = data;
    }

    public T getData() {
        return this.dData;
    }

    public void setNext(DELink<T> next) {
        this.next = next;
    }

    public DELink<T> getNext() {
        return this.next;
    }
}
