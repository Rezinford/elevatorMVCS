import controller.PassengerMoveController;
import model.Building;
import model.Elevator;

import services.building.BuildingServiceImpl;
import services.elevator.ElevatorServiceImpl;
import view.View;

public class SimulationController {
    private PassengerMoveController controller;
    private View view;

    public SimulationController(Building building, Elevator elevator, View view) {
        this.controller = new PassengerMoveController(new BuildingServiceImpl(building), new ElevatorServiceImpl(elevator));
        this.view = view;
    }

    public void run() {
        do {
            view.showFrame();
        } while (step());
    }

    private boolean step() {
        if (controller.isEmotyElevator()) {
            if (controller.searchNewDestination()) {
                controller.move();
                return true;
            }
        } else {
            controller.move();
            return true;
        }
        return false;
    }
}
