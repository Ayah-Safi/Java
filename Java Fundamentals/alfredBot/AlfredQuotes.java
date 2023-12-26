import java.text.SimpleDateFormat;
import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greetingMessage = String.format("Hello %s, Lovely to see you.", name);
        return greetingMessage;
    }

    public String guestGreeting(String name, String dayPeriod) {
        String greetingMessage = String.format("Good %s, %s.Lovely to see you.",dayPeriod, name);
        return greetingMessage;
    }

    public String guestGreeting() {
        String pattern = "HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        String[] newDate = date.split(":");
        int hour = Integer.parseInt(newDate[0]);
        if (hour > 0 && hour <= 12) {
            return "Good morning, it's " + date + " AM. Have a good morning.";
        }

        else if (hour > 12 && hour <= 18){
            return "Good afternoon, it's " + date + " PM. Have a nice day.";
        }

        else {
            return "Good evening, it's " + date + " PM. Have a lovely  evening.";
        }
}
    
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int alexisLength = conversation.indexOf("Alexis");
        int alfredLength = conversation.indexOf("Alfred");
        if (alexisLength != -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(alfredLength != -1){
            return "At your service. As you wish, naturally.";
        }
        else{
             return "Right. And with that I shall retire.";
        }
    }
    public String yellsWhenAngry(String conversation) {
        String alfredAngry = "Make me dinner!";
        if (conversation == alfredAngry){
            return "Hey, I am not your servant make yourself a dinner.";
        }
        else {
            return "";
        }
    }
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}