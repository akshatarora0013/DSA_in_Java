package Basics;

public class _1603_Design_Parking_System {
    class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch(carType){
                case 1:
                    if(big > 0){
                        big--;
                        return true;
                    }
                    break;
                case 2:
                    if(medium > 0){
                        medium--;
                        return true;
                    }
                    break;
                case 3:
                    if(small > 0){
                        small--;
                        return true;
                    }
                    break;
                default:
                    return false;
            }
            return false;
        }
    }
}
