package parkingLot;

import parkingLot.enums.VehcileType;
import parkingLot.spot.FourWheelerParkingSpot;
import parkingLot.spot.ParkingSpot;
import parkingLot.spot.ThreeWheelerParkingSpot;
import parkingLot.tickets.Ticket;
import parkingLot.vehciles.Vehcile;

public class ParkingApplication {
    public static void main(String[] args) throws InterruptedException {
        Vehcile vehcile = new Vehcile("DL-123", VehcileType.FOUR_WHEELER);
        ParkingFloor groundFloor = new ParkingFloor(0);
        
        ParkingSpot spot1 = new FourWheelerParkingSpot();
        ParkingSpot spot2 = new ThreeWheelerParkingSpot();
        groundFloor.addParkingSpot(spot1);
        groundFloor.addParkingSpot(spot2);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addFloors(groundFloor);
        
        Ticket ticket = parkingLot.generateTickets(vehcile);
        
        System.out.print("vehcile type: " + vehcile.getLicensePlate());
        System.out.print("\nticket Id: " + ticket.getTicketId());

        Thread.sleep(5 * 1000);

        String paymentStatus = parkingLot.processPayment(ticket.getTicketId());
        System.out.println("\npayment status is : " + paymentStatus);

    }
}
