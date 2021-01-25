import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class RegionsBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[] f = IntStream.range(0, n * n * 4).toArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i < n - 1) {
                    int bottom = idx + n;
                    merge(f, idx * 4 + 2, bottom * 4);
                }
                if (j < n - 1) {
                    int right = idx + 1;
                    merge(f, idx * 4 + 1, right * 4 + 3);
                }
                if (grid[i].charAt(j) == '/') {
                    merge(f, idx * 4, idx * 4 + 3);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                } else {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                }
            }
        }
        Set<Integer> fathers = new HashSet<>();
        for (int i = 0; i < n * n * 4; i++) {
            int fa = find(f, i);
            fathers.add(fa);
        }
        return fathers.size();
    }

    public int find(int[] f, int x) {
        if (f[x] == x)
            return x;
        int fa = find(f, f[x]);
        f[x] = fa;
        return fa;
    }

    public void merge(int[] f, int x, int y) {
        int fx = find(f, x);
        int fy = find(f, y);
        f[fx] = fy;
    }
}