package view;

import model.Building;
import model.Elevator;
import model.Passenger;
import utility.Direction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ConsoleView implements View {
    private Elevator elevator;
    private Building building;
    private int step = 0;

    public ConsoleView(Elevator elevator, Building building) {
        this.elevator = elevator;
        this.building = building;
    }

    public void showFrame() {
        getViewStep();
        for (int i = (building.getBuildingSize() - 1); i >= 0; i--) {
            getViewFloor(i);
        }
        getViewSeparator();
    }

    private void getViewStep() {
        ++step;
        System.out.println("***************Step " + step + "********************");
        getViewSeparator();

    }

    private void getViewSeparator() {
        StringBuilder separator = new StringBuilder();
        for (int i = 0; i < 50; i++)
            separator.append("-");
        System.out.println(separator.toString());
    }

    private void getViewFloor(int floorNumber) {
        StringBuilder viewfloor = new StringBuilder();
        viewfloor.append("[");
        viewfloor.append((floorNumber >= 10) ? floorNumber : floorNumber + " ");
        viewfloor.append("]");
        viewfloor.append(getViewElevator(floorNumber));
        viewfloor.append("[");
        viewfloor.append(getViewDirection(getFloorDirection(floorNumber)));
        viewfloor.append("] ");
        viewfloor.append(getViewPassengers(building.getFloorList(floorNumber).getPassengerList()));
        System.out.println(viewfloor.toString());
    }

    private String getViewElevator(int floorNumber) {
        int viewsize = (elevator.getCapacity() * 3) + 6;
        StringBuilder viewElevator = new StringBuilder();
        if (elevator.getPosition() == floorNumber) {
            viewElevator.append("[");
            viewElevator.append(getViewDirection(elevator.getDirection()));
            viewElevator.append("][");
            viewElevator.append(getViewPassengers(elevator.getPassengerList()));
            for (int i = viewElevator.length(); i <= viewsize; i++) {
                viewElevator.append("-");
            }
            viewElevator.append("]");
        } else {
            viewElevator.append("    [");
            for (int i = viewElevator.length(); i <= viewsize; i++) {
                viewElevator.append(" ");
            }
            viewElevator.append("]");
        }
        return viewElevator.toString();
    }

    private static String getViewDirection(Direction direction) {
        switch (direction) {
            case UP:
                return "▲ ";
            case DOWN:
                return "▼ ";
            case UP_DOWN:
                return "▲▼";
        }
        return "  ";
    }

    private Direction getFloorDirection(int floorNumber) {
        Set<Direction> Directions = new HashSet<Direction>();
        if (building.getFloorList(floorNumber).getPassengersCount() != 0) {

            for (Passenger pass : building.getFloorList(floorNumber).getPassengerList()) {
                if (pass.getDestination() > floorNumber) {
                    Directions.add(Direction.UP);
                } else {
                    Directions.add(Direction.DOWN);
                }
            }
            return (Directions.size() > 1) ? Direction.UP_DOWN : (Directions.contains(Direction.UP)) ? Direction.UP : Direction.DOWN;
        }
        return Direction.NONE;
    }

    private String getViewPassengers(List<Passenger> passengers) {
        StringBuilder viewPassengers = new StringBuilder();
        for (Passenger pass : passengers) {
            viewPassengers.append((pass.getDestination() >= 10) ? pass.getDestination() + " " : pass.getDestination() + "  ");
        }
        return viewPassengers.toString();
    }
}
