package services.elevator;

import model.Passenger;
import utility.Direction;

import java.util.List;

public interface ElevatorServic {
    void move();

    Direction getDirection();

    void removePassenger(int currentFloor);

    List<Passenger> addPassengers(List<Passenger> passengerList);

    int getPosition();

    void setDestination(int newDestination);

    void searchDestination();

    int getPassengerCount();

    boolean isFull();
}
