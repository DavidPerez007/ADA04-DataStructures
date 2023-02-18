public class LinkedListApp {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        try {
            list.insertDecreasedSorting(21);
            list.insertDecreasedSorting(11.2);
            list.insertDecreasedSorting(41.2);
            list.insertDecreasedSorting(44);
            list.insertDecreasedSorting(1178.2);
            list.insertDecreasedSorting(7);
            list.displayList();
            list.deleteLinkByPosition(7);
            list.displayList();
        } catch (LinkException e) {
            System.out.println(e.getMessage());
        }
        

        // list.deleteLink(11.2);

        // System.out.println("After deleting");
        // list.displayList();
    }
}
