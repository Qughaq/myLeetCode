public class AngleClock {
    public static void main(String[] args) {
        int hour = 3, minutes = 30;
        System.out.println(angleClock(hour, minutes));
    }

    public static double angleClock(int hour, int minutes) {
        double angle = Math.abs(hour * 30 + minutes * 0.5 - minutes * 6);
        return Math.min(angle, 360 - angle);
    }
}
