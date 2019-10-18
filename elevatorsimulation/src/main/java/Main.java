import config.ApplicationConfig;
import model.Building;
import model.Elevator;
import view.ConsoleView;
import view.View;


public class Main {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        Building building = new Building(applicationConfig.generateBuilding());
        Elevator elevator = new Elevator(applicationConfig.getElevatorMaxCapacity());
        View view = new ConsoleView(elevator, building);
        SimulationController simulation = new SimulationController(building, elevator, view);
        simulation.run();
    }
}
