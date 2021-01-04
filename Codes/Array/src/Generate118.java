import java.util.ArrayList;
import java.util.List;

public class Generate118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(getRow(1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < i; j++)
                row.set(j, row.get(j) + row.get(j + 1));
        }
        return row;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            triangle.add(new ArrayList<>(row));
        }
        return triangle;
    }
}
