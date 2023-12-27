import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {

    CafeUtil appTest = new CafeUtil();
        /* ============ App Test Cases ============= */
    
        // System.out.println("\n----- Streak Goal Test -----");
        // System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());
    
        // System.out.println("----- Order Total Test-----");
        // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        // System.out.println("----- Display Menu Test-----");
        
        // ArrayList<String> menu = new ArrayList<String>();
        // menu.add("drip coffee");
        // menu.add("cappuccino");
        // menu.add("latte");
        // menu.add("mocha");
        // appTest.displayMenu(menu);
    
        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }

        // System.out.println("\n----- Print Price Chart-----");
        // appTest.printPriceChart("Colombian Coffee Grounds", 2, 4);

        // System.out.println("\n----- Display Menu-----");
        // ArrayList<String> menuItems = new ArrayList<String>();
        // ArrayList<Double> prices = new ArrayList<Double>();
        // menuItems.add("drip coffee");
        // menuItems.add("cappuccino");
        // menuItems.add("latte");
        // menuItems.add("mocha");
        // prices.add(5.5);
        // prices.add(3.5);
        // prices.add(5.0);
        // prices.add(6.8);
        // appTest.displayMenu(menuItems,prices);

        System.out.println("\n----- Add Customers-----");
        appTest.addCustomers();

    }
}

