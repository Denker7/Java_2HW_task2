import java.util.*;

public class ExplorerMap {

    private Map<String, String> map;
    private StringBuilder builder = new StringBuilder();

    public ExplorerMap() {
        this.map = new HashMap<>();
    }

    public void add(String key, String value) {
        map.put(key, value);
    }

    public void remove(String key) {
        if (key.toLowerCase().equals("all")) {
            map = new HashMap<>();
        } else {
            map.remove(key);
        }
    }

    public void inverseMap() {
        Map<String, List<String>> returnMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (returnMap.containsKey(entry.getValue())) {
                returnMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List list = new ArrayList<String>();
                list.add(entry.getKey());
                returnMap.put(entry.getValue(), list);
            }
        }
        for (Map.Entry<String, List<String>> entry : returnMap.entrySet()) {
            System.out.print(builder.append("[").append(entry.getKey()).append(":{").append(String.join(", ", entry.getValue())).append("}"));
            builder.delete(0, builder.length());
        }
        System.out.println();
    }

    public void print() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(builder.append("[").append(entry.getKey()).append(":").append(entry.getValue()).append("]"));
            builder.delete(0, builder.length());
        }
        System.out.println();
    }
}
