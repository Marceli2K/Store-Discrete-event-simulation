package mitsk.simulation.event.shop;

import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationEvent;

public class PodejscieDoKasy extends SimulationEvent {
    public int currentTime;
    private Simulation simulation;


    public PodejscieDoKasy(int plannedTime, Simulation simulation, Client client) {
        super(plannedTime, client);
        this.currentTime = plannedTime;
        this.simulation = simulation;
    }

    @Override
    public void handle() {
        System.out.println("Klient: " + simulationObject.getSimulationObjectID() + " podszedł do kasy. Czas symulacyjny: " + currentTime);

        this.simulation.register(new Obsluga(currentTime + 4, this.simulation, this.simulationObject));
        this.simulation.register(new Zniecierpliwienie(currentTime + 6, this.simulation, this.simulationObject));


    }
}
