package parkingLot;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkingLot.enums.TicketStatus;
import parkingLot.spot.ParkingSpot;
import parkingLot.tickets.Ticket;
import parkingLot.vehciles.Vehcile;

public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private List<ParkingFloor> parkingFloors;
    private Map<String, Ticket> activeTickets;

    private ParkingLot() {
        this.parkingFloors = new ArrayList<>();
        this.activeTickets = new HashMap<>();
    }
    
    public static ParkingLot getInstance() {
        if(parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot();
        }

        return parkingLotInstance;
    }

    public void addFloors(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public Ticket generateTickets(Vehcile vehcile) {
        for(ParkingFloor floor : parkingFloors) {
            ParkingSpot spot = floor.findFreeParkingSpot(vehcile.getVehcileType());
            if(spot == null)continue;
            spot.bookSpot();
            Ticket newTicket = new Ticket(vehcile, spot);
            activeTickets.put(newTicket.getTicketId(), newTicket);
            return newTicket;
        }
        return null;
    }

    public String processPayment(String ticketId) {
        if(!activeTickets.containsKey(ticketId))return "not an active ticket";
        Ticket ticket = activeTickets.get(ticketId);
        double amount = ticket.getPayment();
        // add the API call to make the payment

        ticket.setTicketStatus(TicketStatus.PAID);
        activeTickets.remove(ticket.getTicketId());
        ticket.setTicketStatus(TicketStatus.PAID);
        ticket.getParkingSpot().freeSpot();
        return "Thanks for paying! Will see you soon";
    }

}
