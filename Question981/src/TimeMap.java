import java.util.ArrayList;
import java.util.HashMap;

// TimeMap class implements a key-value store where each key can have multiple values associated with different timestamps.
public class TimeMap {

    // HashMap to store key-value pairs, where the key is a string, and the value is a list of timestamped values.
    HashMap<String, ArrayList<Pair>> map;

    // Constructor to initialize the HashMap.
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // If the key is not present, initialize an empty list.
        map.putIfAbsent(key, new ArrayList<>());
        // Add the new timestamp-value pair to the list associated with the key.
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the key does not exist, return an empty string.
        if (!map.containsKey(key)) {
            return "";
        }

        // Get the list of timestamped values for the key.
        ArrayList<Pair> arrayList = map.get(key);
        int left = 0, right = arrayList.size() - 1;
        String result = "";  // Store the latest valid value found.

        // Perform binary search to find the largest timestamp <= given timestamp.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = arrayList.get(mid).timeStamp;

            if (time == timestamp) {
                return arrayList.get(mid).val;  // Exact match found, return the value.
            } else if (time > timestamp) {
                right = mid - 1;  // Search in the left half.
            } else {
                result = arrayList.get(mid).val; // Store valid value found so far.
                left = mid + 1;  // Search in the right half.
            }
        }

        // Return the latest valid value found.
        return result;
    }
}

// Helper class to store a timestamp and its corresponding value.
class Pair {
    int timeStamp;  // Timestamp at which the value is stored.
    String val;     // Value associated with the timestamp.

    // Constructor to initialize timestamp and value.
    Pair(int timeStamp, String val) {
        this.timeStamp = timeStamp;
        this.val = val;
    }
}
