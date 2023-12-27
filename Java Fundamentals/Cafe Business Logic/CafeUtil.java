import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(){
        int sum = 0;
        int[] drinksPerWeek = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i <= drinksPerWeek.length-1; i++){
            sum  += drinksPerWeek[i];
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for (int i = 0; i <= prices.length-1; i++){
            sum  += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.printf("%d %s%n", i, menuItems.get(i));
        }

    }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        customers.add(username);
        int arrayListSize = customers.size()-1;
        System.out.printf("Hello, %s!", username);
        System.out.printf("There are %d people in front of you %n",arrayListSize);
        System.out.println(customers);
    }

   public void printPriceChart(String product, double price, int maxQuantity) {
    System.out.println(product); // Print the actual product name

    for (int i = 1; i <= maxQuantity; i++) {
        if (i == 1){
            double productTotalPrice = (price * i);
            System.out.printf("%d - $%.2f %n", i, productTotalPrice);
        }
        else{
            double productTotalPrice = (price * i) - (0.5*(i-1));
            System.out.printf("%d - $%.2f %n", i, productTotalPrice);
        }
        
    }
}
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() == prices.size()) {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.printf("%d %s - $%.2f%n", i, menuItems.get(i), prices.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    public void addCustomers() {
        ArrayList<String> customers = new ArrayList<>();
        String exit;

        do {
            System.out.println("Enter customer name (enter 'q' to exit): ");
            exit = System.console().readLine();

            if (!exit.equals("q")) {
                customers.add(exit);
            }

        } while (!exit.equals("q"));

        System.out.println(customers);
    }
}


