import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getImportance {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subordinate : subordinates) {
            total += dfs(subordinate);
        }
        return total;
    }
}
