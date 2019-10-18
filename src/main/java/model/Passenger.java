package model;

import config.Destination;

public class Passenger implements Destination {
    private int destination;

    public Passenger(int destination) {
        this.destination = destination;
    }

    public int getDestination() {
        return destination;
    }
}
