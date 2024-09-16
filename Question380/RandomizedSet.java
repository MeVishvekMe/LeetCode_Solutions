import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
        
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        if(list.size() == 0) {
            return 0;
        }
        int randomval = rand.nextInt(list.size());
        return list.get(randomval);
    }
    
}
