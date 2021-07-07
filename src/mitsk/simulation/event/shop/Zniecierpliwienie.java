package mitsk.simulation.event.shop;

import mitsk.generators.Uniform;
import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationEvent;
import mitsk.simulation.event.SimulationObject;

public class Zniecierpliwienie extends SimulationEvent {
    public int currentTime;
    private Simulation simulation;
    Uniform uniform = new Uniform(0, 1);

    public Zniecierpliwienie(int plannedTime, Simulation simulation, SimulationObject client){
        super(plannedTime, client);
        this.currentTime=plannedTime;
        this.simulation=simulation;


    }
    @Override
    public void handle() {
        double x = uniform.getNext();
        if (x <= 0.75) {
            System.out.println("Klient: "+ simulationObject.getSimulationObjectID()+" się zniecierpliwil. Czas symulacyjny: "+currentTime);
            simulation.unregister(simulationObject);
        }
        else{
            this.simulation.register(new Zniecierpliwienie(currentTime+6 , this.simulation, this.simulationObject));
        }

    }
}
