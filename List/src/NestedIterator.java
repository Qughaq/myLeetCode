import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private final List<Integer> values;
    private final Iterator<Integer> current;

    public NestedIterator(List<Integer> values, Iterator<Integer> current) {
        this.values = values;
        this.current = current;
    }

//    public NestedIterator(List<NestedInteger> nestedList) {
//        values = new ArrayList<>();
//        dfs(nestedList);
//        current = values.iterator();
//    }
//
//    private void dfs(List<NestedInteger> nestedList) {
//        for (NestedInteger nest : nestedList) {
//            if (nest.isInteger()) {
//                values.add(nest.getInteger());
//            } else {
//                dfs(nest.getList());
//            }
//        }
//    }

    @Override
    public Integer next() {
        return current.next();
    }

    @Override
    public boolean hasNext() {
        return current.hasNext();
    }
}
