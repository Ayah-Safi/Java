import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("A Sky Full of Stars", "Cause you're a sky, 'cause you're a sky full of stars I'm gonna give you my heart");
        trackList.put("Everglow", "Oh, they say people come, say people go This particular diamond was extra special");
        trackList.put("Viva La Vida", "I used to rule the world Seas would rise when I gave the word Now in the morning");
        trackList.put("Yellow", "Look at the stars Look how they shine for you And everything you do");
        String track = trackList.get("Everglow");
        System.out.println("----Print out one of the songs by its track title----");
        System.out.println(track);
        System.out.println("----Print out all the track names and lyrics in the format 'Track: Lyrics'----");
        Set<String> keys = trackList.keySet();
            for(String key : keys) {
                System.out.println(key + ": " + trackList.get(key));
        }
    }
    
}
