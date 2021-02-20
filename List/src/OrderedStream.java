import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    private final String[] arr;
    private final int n;
    private int ptr;

    public OrderedStream(int n) {
        this.n = n;
        this.ptr = 1;
        this.arr = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> result = new ArrayList<>();
        while (ptr <= n && arr[ptr] != null) {
            result.add(arr[ptr]);
            ptr++;
        }
        return result;
    }
}

