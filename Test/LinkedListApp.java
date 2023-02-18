import DELink.DELinkList;

public class LinkedListApp {
    public static void main(String[] args) {
        DELinkList<String> list = new DELinkList<String>();
            list.insertIncreasedSorting("8");
            list.insertIncreasedSorting("7");
            list.insertIncreasedSorting("88");
            list.insertLast("1011");
            list.insertIncreasedSorting("5");
            list.insertIncreasedSorting("25");
            list.insertIncreasedSorting("33");
            list.insertLast("41");
            list.insertIncreasedSorting("7000");
            list.insertIncreasedSorting("100");
            list.displayList();
System.out.println(list.returnLastLink().getData());  
            // list.deleteLinkByPosition(7);
        
        

        // list.deleteLink(11.2);

        // System.out.println("After deleting");
        // list.displayList();
    }
}
