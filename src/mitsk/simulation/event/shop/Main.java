package mitsk.simulation.event.shop;


import mitsk.simulation.event.Simulation;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Simulation simulation = new Simulation();
//        System.out.println("XXX");
        ClientStream clientStream = new ClientStream(simulation);
//        System.out.println("XXX");
        GenClientStream genClientStream = new GenClientStream(simulation.getTime(), simulation, clientStream);
//        System.out.println("XXX");
        simulation.register(genClientStream);
//        System.out.println("XXX");
        simulation.run();
//        System.out.println("XXX");

    }


}
