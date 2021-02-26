import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
    private static ArrayList<Integer> minutes;
    private static ArrayList<String> res;

    public static void main(String[] args) {
        int num = 1;
        System.out.println(readBinaryWatch(num));
    }

    public static List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        minutes = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            dfs(0, 0, i, true);
            dfs(0, 0, num - i, false);
            minutes.clear();
        }

        return res;
    }

    private static void dfs(int start, int sum, int num, boolean flag) {
        if (num == 0) {
            if (flag)
                minutes.add(sum);
            else if (!minutes.isEmpty())
                for (int minute : minutes)
                    res.add(sum + ":" + (minute < 10 ? "0" + minute : minute));
            return;
        }

        for (int i = start; i < (flag ? 6 : 4); i++) {
            int temp = (int) Math.pow(2, i);
            if (flag && sum + temp >= 60 || !flag && sum + temp >= 12) {
                break;
            }
            dfs(i + 1, sum + temp, num - 1, flag);
        }
    }

    public static List<String> readBinaryWatch2(int num) {
        List<String> ans = new ArrayList<>();
        for (int minute = 0; minute < 60; minute++) {
            for (int hour = 0; hour < 12; hour++) {
                int countHour = Integer.bitCount(hour);
                int countMinute = Integer.bitCount(minute);
                if (countHour + countMinute == num) {
                    if (minute < 10)
                        ans.add(hour + ":0" + minute);
                    else
                        ans.add(hour + ":" + minute);
                }
            }
        }
        return ans;
    }
}
