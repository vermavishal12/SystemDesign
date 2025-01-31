package parkingLot.tickets;

import parkingLot.vehciles.Vehcile;

import java.util.UUID;

import parkingLot.enums.ParkingStatus;
import parkingLot.enums.TicketStatus;
import parkingLot.enums.VehcileType;
import parkingLot.pricing.PricingStrategyFactory;
import parkingLot.pricing.SimplePricing;
import parkingLot.spot.ParkingSpot;

public class Ticket {
    private String ticketId;
    private Vehcile vehcile;
    private TicketStatus ticketStatus;
    private ParkingSpot parkingSpot;
    private long startTime;

    public Ticket(Vehcile vehcile, ParkingSpot parkingSpot) {
        this.vehcile = vehcile;
        this.ticketId = UUID.randomUUID().toString();
        this.ticketStatus = TicketStatus.ACTIVE;
        this.parkingSpot = parkingSpot;
        this.startTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return this.getTicketId();
    }

    public double getPayment() {
        long currTime = System.currentTimeMillis();
        long elapsedTime = (currTime - startTime)/1000;
        SimplePricing pricing = PricingStrategyFactory.getSimplePricing(vehcile.getVehcileType());
        return pricing.calculateFees(elapsedTime);
    }

    public TicketStatus getTicketStatus(){
        return this.ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }

}
