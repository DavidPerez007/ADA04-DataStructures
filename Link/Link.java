public class Link<T> {
    private T dData;
    private Link<T> next; 

    public Link(T dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    public void setData(T data){
        this.dData = data;
    }

    public T getData(){
        return this.dData;
    }

    public void setNext(Link<T> next){
        this.next = next;
    }
    
    public Link<T> getNext(){
        return this.next;
    }
}