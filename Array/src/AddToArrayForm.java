import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddToArrayForm {
    public static void main(String[] args) {
        int[] A = {1, 2, 0, 0};
        int K = 34;
        System.out.println(addToArrayForm(A, K));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stackResult = new Stack<>();
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackK = new Stack<>();
        char[] charsK = String.valueOf(K).toCharArray();
        for (char ch : charsK)
            stackK.push(Integer.parseInt(String.valueOf(ch)));
        for (int a : A)
            stackA.push(a);
        int remain = 0;
        int len = Math.max(stackA.size(), stackK.size());
        while (len > 0) {
            int sum = 0;
            if (!stackA.empty() && !stackK.empty())
                sum = stackA.pop() + stackK.pop() + remain;
            else if (!stackA.empty())
                sum = stackA.pop() + remain;
            else if (!stackK.empty())
                sum = stackK.pop() + remain;
            stackResult.push(sum % 10);
            remain = sum / 10;
            len--;
        }
        if (remain > 0) stackResult.push(remain);
        while (!stackResult.empty())
            result.add(stackResult.pop());
        return result;
    }
}
