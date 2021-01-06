public class Solution {
    public static void main(String[] args) throws InterruptedException {
        MovingAverage obj = new MovingAverage(4);
        System.out.println(obj.next(100));
        System.out.println(obj.next(-10));
        System.out.println(obj.next(-300));
        System.out.println(obj.next(50));
        System.out.println(obj.next(0));
    }
}
