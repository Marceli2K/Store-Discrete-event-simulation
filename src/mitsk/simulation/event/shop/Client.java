package mitsk.simulation.event.shop;

import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationObject;

public class Client extends SimulationObject {
    protected int clientID;

    public Client(Simulation simulation, int clientID) {
        super(simulation);
        this.clientID = clientID;
    }

    @Override
    public int getSimulationObjectID() {
        return this.clientID;
    }
}