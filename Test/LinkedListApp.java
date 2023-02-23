import javax.naming.LinkException;

import DELink.DELinkList;

public class LinkedListApp {
    public static void main(String[] args) {
        DELinkList<Integer> list = new DELinkList<Integer>();
        list.insertIncreasedSorting(8);
        list.insertIncreasedSorting(7);
        list.insertIncreasedSorting(88);
        list.insertLast(1011);
        list.insertIncreasedSorting(5);
        list.insertIncreasedSorting(25);
        list.insertIncreasedSorting(33);
        list.insertLast(41);
        list.insertIncreasedSorting(7000);
        list.insertIncreasedSorting(100);
        System.out.println("last: " + list.returnLastLink().getData());

        list.displayList();
        System.out.println(list.findPosition(7000));
        
        list.displayList();

       
    }
}
