import DELink.DELinkList;

public class LinkedListApp {
    public static void main(String[] args) {
        DELinkList<String> list = new DELinkList();
        try {
            list.insertFirst("Joselito");
            list.insertFirst("Manolito");
            list.insertFirst("Davisito");
            list.insertFirst("Marianito");
            list.insertFirst("Arturitu");
            list.insertFirst("Josefino");
            list.displayList();
            list.deleteLinkByPosition(7);
            list.displayList();
        } catch (LinkException e) {
            System.out.println(e.getMessage());
        } catch(Exception a){
            a.printStackTrace();
        }
        

        // list.deleteLink(11.2);

        // System.out.println("After deleting");
        // list.displayList();
    }
}
