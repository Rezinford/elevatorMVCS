package controller;


import model.Building;
import model.Passenger;
import services.building.BuildingServic;
import services.elevator.ElevatorServic;
import utility.Direction;

import java.util.ArrayList;
import java.util.List;

public class PassengerMoveController {
    private BuildingServic buildingServic;
    private ElevatorServic elevatorServic;

    public PassengerMoveController(BuildingServic buildingServic, ElevatorServic elevatorServic) {
        this.buildingServic = buildingServic;
        this.elevatorServic = elevatorServic;
    }

    public void move() {
        addPassengerElevator();
        elevatorServic.move();
    }

    public boolean searchNewDestination() {
        if (elevatorServic.getDirection() == Direction.UP | elevatorServic.getDirection() == Direction.NONE) {
            return (searchSignalUP()) ? true : (searchSignalDown()) ? true : false;
        } else {
            return (searchSignalDown()) ? true : (searchSignalUP()) ? true : false;
        }
    }

    private boolean searchSignalUP() {
        for (int i = elevatorServic.getPosition(); i < buildingServic.getFloorCount(); i++) {
            if (buildingServic.getPassengers(i).size() > 0) {
                elevatorServic.setDestination(i);
                addPassengerElevator();
                return true;
            }
        }
        return false;
    }

    private boolean searchSignalDown() {
        int position = elevatorServic.getPosition();
        for (int i = position; i >= 0; i--) {
            if (buildingServic.getPassengers(i).size() > 0) {
                elevatorServic.setDestination(i);
                addPassengerElevator();
                return true;
            }
        }
        return false;
    }

    public void addPassengerElevator() {
        elevatorServic.removePassenger(elevatorServic.getPosition());
        if(elevatorServic.getPassengerCount()!=0){
            elevatorServic.searchDestination();
        }
        if (!elevatorServic.isFull()) {
            buildingServic.removePassenger(elevatorServic.getPosition(), elevatorServic.addPassengers(getPassengerList(elevatorServic.getDirection())));
            elevatorServic.getDirection();
        }
    }

    public List<Passenger> getPassengerList(Direction direct) {
        List<Passenger> tempPassengerList = new ArrayList<Passenger>();
        for (Passenger pass : buildingServic.getPassengers(elevatorServic.getPosition())) {
            switch (direct) {
                case UP:
                    if (pass.getDestination() > elevatorServic.getPosition()) tempPassengerList.add(pass);
                    break;
                case DOWN:
                    if (pass.getDestination() < elevatorServic.getPosition()) tempPassengerList.add(pass);
                    break;
                case NONE:
                    tempPassengerList.add(pass);
                    break;
            }
        }
        return tempPassengerList;
    }

    public boolean isEmotyElevator() {
        return (elevatorServic.getPassengerCount() == 0);
    }

}
