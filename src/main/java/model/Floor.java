package model;

import utility.Direction;


import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Passenger> passengersList;

    public Floor(List<Passenger> passengersList) {
        this.passengersList = passengersList;
    }

    public Floor() {
        this.passengersList = new ArrayList<Passenger>();
    }

    public void addPassenger(Passenger passenger) {
        passengersList.add(passenger);
    }

    public void addPassenger(List<Passenger> passenger) {
        passengersList.addAll(passenger);
    }

    public void removePassenger(Passenger passenger) {
        passengersList.remove(passenger);
    }

    public void removePassenger(List<Passenger> passenger) {
        passengersList.removeAll(passenger);
    }

    public List<Passenger> getPassengerList() {
        return passengersList;
    }

    public int getPassengersCount() {
        return passengersList.size();
    }
}
