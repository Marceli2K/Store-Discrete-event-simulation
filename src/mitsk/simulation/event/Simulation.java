package mitsk.simulation.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Simulation {
    protected int currentTime = 0;
    protected List<SimulationEvent> simulationEventObjectList = new ArrayList();

    public Simulation() {
        this.currentTime = 0;
    }


    public int getTime() {
        return currentTime;
    }

    public void register(SimulationEvent simulationEvent) {

        if (simulationEvent.plannedTime < currentTime) {
            System.out.println("To wydarzenie jest przeszłe");
        } else {

            simulationEventObjectList.add(simulationEvent);
            Comparator<SimulationEvent> comparator = Comparator.comparingInt(e -> e.plannedTime);
            Collections.sort(simulationEventObjectList, comparator);

        }

    }


    public void unregister(SimulationObject simulationObject) {
        ArrayList<SimulationEvent> simulationEventObjectListToDelete = new ArrayList<SimulationEvent>();
        int val = 0;
        for (SimulationEvent event : simulationEventObjectList) {
            if (event.simulationObject == simulationObject && simulationEventObjectList.indexOf(event) != 0) {
                simulationEventObjectListToDelete.add(event);
                val = simulationEventObjectList.indexOf(event);
            }
        }
        if (val != -1) {
            simulationEventObjectList.remove(simulationEventObjectList.get(val));
        }

    }

    public void run() throws InterruptedException {
        while (simulationEventObjectList.size() > 0) {
            SimulationEvent currentEvent = simulationEventObjectList.get(0);
            currentTime = currentEvent.plannedTime;
            currentEvent.handle();
            simulationEventObjectList.remove(0);
        }
    }


}
