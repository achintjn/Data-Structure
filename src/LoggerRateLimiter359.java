import java.util.HashMap;

public class LoggerRateLimiter359 {
    HashMap<String, Integer> lookup;
    public void Logger() {
        lookup = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(lookup.containsKey(message))
        {
            if(lookup.get(message)+10>timestamp)
            {

                return false;
            }

        }
        lookup.put(message,timestamp);
        return true;
    }
}
