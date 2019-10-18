package model;

import utility.Direction;

import java.util.List;

import static utility.Direction.*;

public class Elevator extends Floor {
    private int capacity;
    private int position;
    private int destination;

    public Elevator(int capacity) {
        this.capacity = capacity;
        this.position = 0;
        this.destination = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDestination(int newdestination) {
        this.destination = newdestination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPosition() {
        return position;
    }

    public int getDestination() {
        return destination;
    }

    public Direction getDirection() {
        return (destination == position) ? NONE : (destination > position) ? UP : DOWN;
    }

}
