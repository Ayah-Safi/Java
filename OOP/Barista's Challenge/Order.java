import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    ArrayList<Item> items;
    
    public Order(){
        this.name = "Guest";
        items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public boolean getReady(){
        return this.ready;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public String getStatusMessage(){
        String readyMessage = "Your order is ready.";
        String notReadyMeassage = "Thank you for waiting. Your order will be ready soon.";
        if (this.ready){
            return readyMessage;
        }
        else{
            return notReadyMeassage;
        }

    }

    public double getOrderTotal(){
        double total = 0.0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getPrice();

        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: "+this.name);
        for(Item item : items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }
}
