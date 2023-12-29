public class OrderTest {
    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Ayah");
        Order order4 = new Order("Haya");
        Order order5 = new Order("Heba");

        Item item1 = new Item("drip coffee", 1.50);
        Item item2 = new Item("capuccino", 3.50);
        Item item3 = new Item("iced coffee", 2.15);
        Item item4 = new Item("mocha", 3.10);

        order2.addItem(item1);
        order2.addItem(item2);
        System.out.println(order2.getStatusMessage());
        System.out.println(order2.getOrderTotal());
        order2.display();

        order3.addItem(item1);
        order3.addItem(item2);
        order3.setReady(true);
        System.out.println(order3.getStatusMessage());
        System.out.println(order3.getOrderTotal()); 
        order3.display();
        

       

    }
    
}
