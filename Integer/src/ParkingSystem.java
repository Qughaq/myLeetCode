public class ParkingSystem {
    public static int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        ParkingSystem.big = big;
        ParkingSystem.medium = medium;
        ParkingSystem.small = small;
    }

    public boolean addCar(int carType) {
        if (carType < 1 || carType > 3)
            return false;
        if (carType == 1)
            return big-- > 0;
        if (carType == 2)
            return medium-- > 0;
        return small-- > 0;
    }
}
