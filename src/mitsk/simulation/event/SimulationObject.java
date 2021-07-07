package mitsk.simulation.event;

public abstract class SimulationObject {
    Simulation simulation;

    protected SimulationObject(Simulation simulation) {
        this.simulation = simulation;
    }
    public abstract int getSimulationObjectID();
}
