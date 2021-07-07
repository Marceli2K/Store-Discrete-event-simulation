package mitsk.simulation.continuous.rk;

import mitsk.simulation.continuous.rk.relations.Function;
/*
 * TODO
 * sprawdz dlaczego jest przesunięcie o jeden w wynikach :<
 * */
public class RK4 {
    public RK4() {

    }

    public void solve(Function derivative, double initialValue, double firstX, double lastX, double step) {
        double currentX = firstX;
        double y = initialValue;
        double k1, k2, k3, k4, k5;
        while (lastX >= currentX) {

            // Apply Runge Kutta Formulas to find
            // next value of y
            k1 = step * (derivative.getValue(currentX, y));
            k2 = step * (derivative.getValue(currentX + 0.5 * step, y + 0.5 * k1));
            k3 = step * (derivative.getValue(currentX + 0.5 * step, y + 0.5 * k2));
            k4 = step * (derivative.getValue(currentX + step, y + k3));

            // Update next value of y
            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
//            System.out.println("Calculating x " + currentX + " y " + y);
            if (currentX == 1 || currentX == 2 || currentX == 3 || currentX == 4) {
                System.out.println("*RK4* Calculating x " + (currentX) + " y " + y);
            }
            currentX += step;
        }

    }
}
