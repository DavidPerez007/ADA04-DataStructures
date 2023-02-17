public class Link {
    private double dData;
    private Link next; 

    public Link(double dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    public void setData(double data){
        this.dData = data;
    }

    public double getData(){
        return this.dData;
    }

    public void setNext(Link next){
        this.next = next;
    }
    
    public Link getNext(){
        return this.next;
    }
}