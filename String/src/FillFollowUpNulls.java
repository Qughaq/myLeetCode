import java.util.Arrays;
import java.util.List;

public class FillFollowUpNulls {
    public static void main(String[] args) {
        List<String> valueList = Arrays.asList(null, "as", null, "sds", null, null, null, "Good", null, null, null);
        System.out.println(fillFollowUpNulls1(valueList, 10));
    }

    public static List<String> fillFollowUpNulls1(List<String> valueList, int len) {
        String fill = valueList.get(0);
        for (int i = 0; i < len; i++) {
            if (valueList.get(i) == null) {
                valueList.set(i, fill);
            } else {
                fill = valueList.get(i);
            }
        }
        return valueList;
    }

    public static List<String> fillFollowUpNulls(List<String> valueList, int len) {
        for (int i = 0; i < len; i++) {
            if (valueList.get(i) != null) {
                String temp = valueList.get(i);
                while (i < len && valueList.get(i) != null) {
                    valueList.set(i, temp);
                    i++;
                }
            }
        }
        return valueList;
    }
}
