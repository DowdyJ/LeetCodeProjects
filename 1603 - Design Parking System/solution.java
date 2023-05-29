class ParkingSystem {

    int[] carspots = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.carspots[0] = big;
        this.carspots[1] = medium;
        this.carspots[2] = small;
    }
    
    public boolean addCar(int carType) {
        return --carspots[carType - 1] >= 0;
    }
}