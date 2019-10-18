package services.elevator;

import model.Elevator;
import model.Passenger;
import utility.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElevatorServiceImpl implements ElevatorServic {
    public ElevatorServiceImpl(Elevator elevator) {
        this.elevator = elevator;
    }

    private Elevator elevator;

    public void move() {
        switch (getDirection()) {
            case UP:
                elevator.setPosition(getPosition() + 1);
                break;
            case DOWN:
                elevator.setPosition(getPosition() - 1);
                break;
        }
    }

    public Direction getDirection() {
        return elevator.getDirection();

    }

    public int getPosition() {
        return elevator.getPosition();
    }

    public void removePassenger(int currentFloor) {
        List<Passenger> outPassenger = new ArrayList<Passenger>();
        for (Passenger pass : elevator.getPassengerList()) {
            if (pass.getDestination() == currentFloor) {
                outPassenger.add(pass);
            }
        }
        elevator.removePassenger(outPassenger);
    }

    public List<Passenger> addPassengers(List<Passenger> passengerList) {
        List<Passenger> tempaPassengersaddtoElevator = new ArrayList<Passenger>();
        int count = elevator.getCapacity() - getPassengerCount();
        if (passengerList.size() > count) {
            for (int i = 0; i < count; i++) {
                elevator.addPassenger(passengerList.get(i));
                tempaPassengersaddtoElevator.add(passengerList.get(i));
            }
        } else {
            elevator.addPassenger(passengerList);
            tempaPassengersaddtoElevator.addAll(passengerList);
        }
        return tempaPassengersaddtoElevator;
    }

    public int getPassengerCount() {
        return elevator.getPassengerList().size();
    }

    public void setDestination(int newDestination) {
        elevator.setDestination(newDestination);
    }

    public boolean isFull() {
        return (elevator.getCapacity() == elevator.getPassengersCount());
    }

    public void searchDestination() {
        switch (elevator.getDirection()) {
            case UP:
            case NONE:
                elevator.setDestination(getMaxNumber(elevator.getPassengerList()));
                break;
            case DOWN:
                elevator.setDestination(getMinNumber(elevator.getPassengerList()));
                break;
        }
    }

    private int getMaxNumber(List<Passenger> passengers) {
        int max = 0;
        for (Passenger pass : passengers) {
            if (pass.getDestination() > max)
                max = pass.getDestination();
        }
        return max;
    }

    private int getMinNumber(List<Passenger> passengers) {
        int min = 0;
        for (Passenger pass : passengers) {
            if (pass.getDestination() < min)
                min = pass.getDestination();
        }
        return min;
    }
}
