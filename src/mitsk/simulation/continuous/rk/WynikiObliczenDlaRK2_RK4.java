package mitsk.simulation.continuous.rk;

import mitsk.simulation.continuous.rk.relations.Function;

public class WynikiObliczenDlaRK2_RK4 {
    public WynikiObliczenDlaRK2_RK4(){

    }
    public static void main(String args[]) throws InterruptedException {
        RK2 rk2 = new RK2();
        RK4 rk4 = new RK4();
        RKF5 rkf5 = new RKF5();
//////        2A
        System.out.println("\n #########ZADANIE 2A ############");
        Function function2A = new _2A();
        rk2.solve(function2A, 1, 0, 4, 0.5);
        rk4.solve(function2A, 1, 0, 4, 0.5);
        rk2.solve(function2A, 1, 0, 4, 1.0);
        rk4.solve(function2A, 1, 0, 4, 1.0);
        rk2.solve(function2A, 1, 0, 4, 2.0);
        rk4.solve(function2A, 1, 0, 4, 2.0);
        rk2.solve(function2A, 1, 0, 4, 4.0);
        rk4.solve(function2A, 1, 0, 4, 4.0);
////        2B
        //////        2A
        System.out.println("\n #########ZADANIE 2B ############");
        Function function2B = new _2B();
        rk2.solve(function2B, 1, 0, 4, 0.5);
        rk4.solve(function2B, 1, 0, 4, 0.5);
        rk2.solve(function2B, 1, 0, 4, 1.0);
        rk4.solve(function2B, 1, 0, 4, 1.0);
        rk2.solve(function2B, 1, 0, 4, 2.0);
        rk4.solve(function2B, 1, 0, 4, 2.0);
        rk2.solve(function2B, 1, 0, 4, 4.0);
        rk4.solve(function2B, 1, 0, 4, 4.0);
////        2C
        //////        2A
        System.out.println("\n #########ZADANIE 2C ############");
        Function function2C = new _2C();
        rk2.solve(function2C, 1, 0, 4, 0.5);
        rk4.solve(function2C, 1, 0, 4, 0.5);
        rk2.solve(function2C, 1, 0, 4, 1.0);
        rk4.solve(function2C, 1, 0, 4, 1.0);
        rk2.solve(function2C, 1, 0, 4, 2.0);
        rk4.solve(function2C, 1, 0, 4, 2.0);
        rk2.solve(function2C, 1, 0, 4, 4.0);
        rk4.solve(function2C, 1, 0, 4, 4.0);

////        2D
        //////        2A
        System.out.println("\n #########ZADANIE 2D ############");
        Function function2D = new _2D();
        rk2.solve(function2D, 1, 0, 4, 0.5);
        rk4.solve(function2D, 1, 0, 4, 0.5);
        rk2.solve(function2D, 1, 0, 4, 1.0);
        rk4.solve(function2D, 1, 0, 4, 1.0);
        rk2.solve(function2D, 1, 0, 4, 2.0);
        rk4.solve(function2D, 1, 0, 4, 2.0);
        rk2.solve(function2D, 1, 0, 4, 4.0);
        rk4.solve(function2D, 1, 0, 4, 4.0);

// ZAD3
        //////        2A
        System.out.println("\n #########ZADANIE 3 ############");
        Function function3 = new _3();
        rkf5.solve(function3, 1, 0, 4, 0.5);
    }
}
