package parkingLot;

import java.util.ArrayList;
import java.util.List;

import parkingLot.enums.ParkingStatus;
import parkingLot.enums.VehcileType;
import parkingLot.spot.ParkingSpot;

public class ParkingFloor {
    private List<ParkingSpot> parkingSlots;
    private int floorNumnber;

    public ParkingFloor (int floorNumnber) {
        this.floorNumnber = floorNumnber;
        parkingSlots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSlots.add(parkingSpot);
    }

    public ParkingSpot findFreeParkingSpot(VehcileType vehcileType) {
        if(parkingSlots.size() == 0) {
            return null;
        }

        for(ParkingSpot parkingSpot : parkingSlots) {
            if(parkingSpot.geParkingStatus() == ParkingStatus.EMPTY 
                    && parkingSpot.getType() == vehcileType) {
                return parkingSpot;
            }
        }
        return null;
    }
}
