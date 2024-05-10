package Aula9.Exer3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneManager {
    private Map<String, Plane> planes = new HashMap<>();

    public void addPlane(Plane plane) {
        planes.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        planes.remove(id);
    }

    public Plane searchPlane(String id) {
        return planes.get(id);
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> commercialPlanes = new ArrayList<>();

        for (Plane plane : planes.values()) {
            if (plane instanceof CommercialPlane) {
                commercialPlanes.add(plane);
            }
        }

        return commercialPlanes;
    }

    public List<Plane> getMilitaryPlanes() {
        List<Plane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes.values()) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add(plane);
            }
        }

        return militaryPlanes;
    }

    public Plane getFastestPlane() {
        Plane fastestPlane = null;

        for (Plane plane : planes.values()) {
            if (fastestPlane == null || plane.getMaxSpeed() > fastestPlane.getMaxSpeed()) {
                fastestPlane = plane;
            }
        }

        return fastestPlane;
    }

    public void printAllPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    public void printCommercialPlanes() {
        for (Plane plane : getCommercialPlanes()) {
            System.out.println(plane);
        }
    }

    public void printMilitaryPlanes() {
        for (Plane plane : getMilitaryPlanes()) {
            System.out.println(plane);
        }
    }

    public void printFastestPlane() {
        System.out.println(getFastestPlane());
    }

}
