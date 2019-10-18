package services.building;

import model.Passenger;
import utility.Direction;

import java.util.List;

public interface BuildingServic {
    void removePassenger(int floorNumber, List<Passenger> outPassenger);
    List<Passenger> getPassengers(int floorNumber);
    int getFloorCount();
}
