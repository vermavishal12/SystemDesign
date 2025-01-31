package parkingLot.spot;

import java.util.UUID;

import parkingLot.enums.*;
import parkingLot.vehciles.Vehcile;

public abstract class ParkingSpot {
    private String spotId;
    private VehcileType vechileType;
    private ParkingStatus parkingStatus;

    public ParkingSpot(VehcileType vechileType) {
        this.spotId = UUID.randomUUID().toString();
        this.vechileType = vechileType;
        this.parkingStatus = ParkingStatus.EMPTY;
    }

    public ParkingStatus geParkingStatus() {
        return this.parkingStatus;
    }

    public void bookSpot() {
        this.parkingStatus = ParkingStatus.FILLED;
    }

    public void freeSpot() {
        this.parkingStatus = ParkingStatus.EMPTY;
    }

    public VehcileType getType() {
        return this.vechileType;
    }

}