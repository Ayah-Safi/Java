public class OrderTest {
    public static void main(String[] args) {

      

        CoffeeKiosk coffeeKiosk1 = new CoffeeKiosk();

      

        coffeeKiosk1.addMenuItem("banana", 2.00);
        coffeeKiosk1.addMenuItem("coffee", 1.50);
        coffeeKiosk1.addMenuItem("latte", 3.00);
        coffeeKiosk1.addMenuItem("cupuccino", 4.50);
        coffeeKiosk1.addMenuItem("muffin", 5.00);
        coffeeKiosk1.newOrder();
        

       

    }
    
}
