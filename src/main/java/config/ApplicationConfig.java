package config;

import model.Building;
import model.Floor;
import model.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationConfig {
    private int MIN_FLOOR = 5;
    private int MAX_FLOOR = 10;
    private int MIN_FLOOR_PASS = 0;
    private int MAX_FLOOR_PASS = 10;
    private int MAX_ELEVATOR_PASS = 5;

    private int FLOOR_NUMBER;

    public ApplicationConfig() {
        if (MAX_ELEVATOR_PASS <= 0) throw new IllegalArgumentException("Error capacity");
        if ((MAX_FLOOR_PASS <= 0) |(MIN_FLOOR_PASS > MAX_FLOOR_PASS))
            throw new IllegalArgumentException("Error Passenger Count Range");
        if ((MIN_FLOOR <= 0)|(MIN_FLOOR > MAX_FLOOR))
            throw new IllegalArgumentException("Error FLOOR Count Range");
        FLOOR_NUMBER = calculateNum(MIN_FLOOR, MAX_FLOOR);

    }

    private int calculateNum(int min, int max) {
        Random random = new Random();
        return (min + random.nextInt(max - min));
    }

    private Passenger generatePassenger(int position) {
        int destination = position;
        while (destination == position)
            destination = calculateNum(FLOOR_NUMBER +1);
        return new Passenger(destination);
    }
    private int calculateNum(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    private Floor generateFloor(int florNumber) {
        int countPassenger = calculateNum(MAX_FLOOR_PASS);
        List<Passenger> passengerList = new ArrayList<Passenger>();
        for (int i = 0; i <= countPassenger; i++) {
            passengerList.add(generatePassenger(florNumber));
        }
        return new Floor(passengerList);
    }

    public List<Floor> generateBuilding() {
        int countFloor = FLOOR_NUMBER;
        List<Floor> floorList = new ArrayList<Floor>();
        for (int i = 0; i <= countFloor; i++) {
            floorList.add(generateFloor(i));
        }
        return floorList;
    }

    public int getElevatorMaxCapacity(){
        return MAX_ELEVATOR_PASS;
    }

}
