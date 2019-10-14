package model;

import java.util.List;

public class Building {
    private List<Floor> floorList;

    public Building(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public Floor getFloorList(int number) {
        return floorList.get(number);
    }

    public int getBuildingSize() {
        return floorList.size();
    }

}
