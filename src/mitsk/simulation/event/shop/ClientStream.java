package mitsk.simulation.event.shop;


import mitsk.generators.RoundRobin;
import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationObject;

public class ClientStream extends SimulationObject {
    protected int[] numberForGenerate = {8, 7, 5};
    RoundRobin sizeOfClientStream = new RoundRobin(numberForGenerate);
    int numberSizeOfClientStream;

    ClientStream(Simulation simulation) throws InterruptedException {
        super(simulation);
        this.numberSizeOfClientStream = (int) sizeOfClientStream.getNext();

    }

    @Override
    public int getSimulationObjectID() {
        return 0;
    }


}
