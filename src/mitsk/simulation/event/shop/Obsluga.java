package mitsk.simulation.event.shop;

import mitsk.generators.Uniform;
import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationEvent;
import mitsk.simulation.event.SimulationObject;

public class Obsluga extends SimulationEvent {
    public int currentTime;
    private Simulation simulation;
    Uniform uniform = new Uniform(0, 1);

    public Obsluga(int plannedTime, Simulation simulation, SimulationObject client) {
        super(plannedTime, client);
        this.simulation = simulation;
        this.currentTime = plannedTime;


    }

    @Override
    public void handle() {
        double prawdObslugi = uniform.getNext();
        if (prawdObslugi <= 0.5) {
            System.out.println("Klient: " + simulationObject.getSimulationObjectID() + " został obsluzony. Czas symulacyjny: " + currentTime);
            simulation.unregister(simulationObject);
        } else {
            this.simulation.register(new Obsluga(currentTime + 4, this.simulation, this.simulationObject));
        }

    }
}
