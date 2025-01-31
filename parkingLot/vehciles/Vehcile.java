package parkingLot.vehciles;

import java.util.UUID;

import parkingLot.enums.VehcileType;

public class Vehcile {
    private String licensePlate;
    private VehcileType vehcileType;

    public Vehcile(String licensePlate, VehcileType vehcileType) {
        this.licensePlate = licensePlate;
        this.vehcileType = vehcileType;
    }

    public VehcileType getVehcileType() {
        return this.vehcileType;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

}
