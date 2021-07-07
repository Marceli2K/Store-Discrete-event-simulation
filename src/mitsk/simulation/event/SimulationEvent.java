package mitsk.simulation.event;

import mitsk.simulation.event.shop.ClientStream;

public abstract class SimulationEvent {
    protected SimulationObject simulationObject;
    public int plannedTime;

    protected SimulationEvent(int plannedTime,  SimulationObject simulationObject) {
        this.plannedTime = plannedTime;
        this.simulationObject = simulationObject;
    }

    protected void handle() throws InterruptedException {

    }
}
