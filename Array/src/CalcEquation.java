import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcEquation {
    private static double[][] graph;

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        // 给字符设置唯一编号
        for (List<String> equation : equations)
            for (String e : equation)
                if (!map.containsKey(e))
                    map.put(e, index++);
        // 建立邻接矩阵
        graph = new double[index + 1][index + 1];
        index = 0;
        for (List<String> equation : equations) {
            int a = map.get(equation.get(0));
            int b = map.get(equation.get(1));
            double value = values[index++];
            graph[a][b] = value;
            graph[b][a] = 1 / value;
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> tmp = queries.get(i);
            boolean[] vis = new boolean[graph.length];
            // 未存在的顶点
            if (map.get(tmp.get(0)) == null || map.get(tmp.get(1)) == null) {
                res[i] = -1;
                continue;
            }
            int a = map.get(tmp.get(0));
            int b = map.get(tmp.get(1));
            res[i] = dfs(a, b, graph.length, vis);
            // 将得出值的结果添加到邻接矩阵
            if (res[i] != -1 && graph[a][b] != 0) {
                graph[a][b] = res[i];
                graph[b][a] = 1 / res[i];
            }
        }
        return res;
    }

    static double dfs(int a, int b, int len, boolean[] vis) {
        if (graph[a][b] != 0) return graph[a][b];
        // 记录遍历过的顶点,防止重复
        vis[a] = true;
        for (int i = 0; i < len; i++)
            if (!vis[i] && graph[a][i] != 0) {
                double tmp = dfs(i, b, len, vis);
                if (tmp != -1)
                    return graph[a][i] * tmp;
            }
        return -1;
    }
}
