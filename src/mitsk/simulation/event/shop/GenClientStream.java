package mitsk.simulation.event.shop;


import mitsk.generators.RoundRobin;
import mitsk.generators.Uniform;
import mitsk.simulation.event.Simulation;
import mitsk.simulation.event.SimulationEvent;

public class GenClientStream extends SimulationEvent {

    protected Simulation simulation;
    protected ClientStream clientStream;
    private Uniform uniformTimeBetweenRegister = new Uniform(4, 6);
    int[] numberForGenerate = {8, 7, 5};
    private RoundRobin sizeOfClientStream = new RoundRobin(numberForGenerate);
    private Uniform goToCashRegister;

    GenClientStream(int plannedTime, Simulation simulation, ClientStream clientStream) {
        super(plannedTime, clientStream);
        this.clientStream = clientStream;
        this.simulation = simulation;

    }


    @Override
    public void handle() throws InterruptedException {
        int generatedClients = 0;
        int currentTime = this.simulation.getTime();

        while (generatedClients < 20) {

            int x = (int) sizeOfClientStream.getNext();
            for (int i = 0; i <= x; i++) {
                if (generatedClients < 20) {
                    Client client = new Client(this.simulation, generatedClients);

                    this.simulation.register(new PodejscieDoKasy(currentTime + (int) new Uniform(7, 12).getNext(), this.simulation, client));

                    generatedClients++;
                }

            }
            currentTime += (int) uniformTimeBetweenRegister.getNext();
        }

    }
}
