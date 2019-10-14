package services.building;

import model.Building;
import model.Elevator;
import model.Floor;
import model.Passenger;
import utility.Direction;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildingServiceImpl implements BuildingServic {
    private Building building;

    public BuildingServiceImpl(Building building) {
        this.building = building;
    }

    public void removePassenger(int floorNumber, List<Passenger> outPassenger) {
        building.getFloorList(floorNumber).removePassenger(outPassenger);
    }

    public List<Passenger> getPassengers(int floorNumber) {
        return building.getFloorList(floorNumber).getPassengerList();
    }

    public int getFloorCount() {
        return building.getBuildingSize();
    }
}
