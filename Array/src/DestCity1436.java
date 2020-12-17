import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DestCity1436 {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> hashSet = new HashSet<>();
        for (List<String> path : paths)
            hashSet.add(path.get(1));
        for (List<String> path : paths)
            hashSet.remove(path.get(0));
        return hashSet.iterator().next();
    }

    public static String destCity1(List<List<String>> paths) {
        Set<String> hashSet = new HashSet<>();
        for (List<String> path : paths)
            hashSet.add(path.get(0));
        for (List<String> path : paths)
            if (!hashSet.contains(path.get(1)))
                return path.get(1);
        return null;
    }

    public static String destCity2(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths)
            map.put(path.get(0), path.get(1));
        for (List<String> path : paths)
            if (!map.containsKey(path.get(1)))
                return path.get(1);
        return null;
    }
}
