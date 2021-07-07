package mitsk.simulation.continuous.rk;
/*
 * TODO
 * sprawdz poprawnosc działania tej metody
 * */

import mitsk.simulation.continuous.rk.relations.Function;

public class RK2 {
    public RK2() {

    }

    public void solve(Function derivative, double initialValue, double firstX, double lastX, double step) {
        double currentX = firstX;
        double y = initialValue;
        while (lastX >= currentX) {
            double k1 = step * derivative.getValue(currentX, y);
            double k2 = step * derivative.getValue(currentX + 0.5 * step,
                    y + 0.5 * k1);

            // Update next value of y
            y = y + (1.0 / 4.0) * (k1 + 2 * k2);
//            y = y + derivative.getValue(currentX + 0.5 * step, y + 0.5 * k1);


            if (currentX == 1 || currentX == 2 || currentX == 3 || currentX == 4) {
                System.out.println("*RK2* Calculating x " + (currentX) + " y " + y);
            }
            currentX += step;

        }

    }
}
