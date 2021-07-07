package mitsk.simulation.continuous.rk;
/*
 * TODO
 * W pakiecie mtisk.simulation. continuous.rk należy stworzyć klasę RKF5 implementującą algorytm Runge-Kutta-Fehlberga.
 * Podczas zmiany długości kroku klasa powinna wyświetlać informację o nowej długości kroku oraz obecnej wartości x.
 * Zademonstrować działanie metody  dla  funkcji 6-2𝑥/y,  parametry  jak  w poprzednim zadaniu, z wyjątkiem:
 * 1.Inicjalny krok = 0.01,
 * 2.Minimalny błąd 0.01,
 * 3.Maksymalny błąd 0.5.
 * */

import mitsk.simulation.continuous.rk.relations.Function;

import static java.lang.Thread.sleep;

public class RKF5 {
    public RKF5() {
    }

    public void solve(Function derivative, double initialValue, double firstX, double lastX, double step) throws InterruptedException {
        double currentX = firstX;
        double y = initialValue;
        double stepUsed = 0.01;
        System.out.println("Długośc nowego kroku to : " + stepUsed + "");
        while (lastX >= currentX) {
            double k1 = stepUsed * derivative.getValue(currentX, y);
            double k2 = stepUsed * derivative.getValue(currentX + stepUsed * 2.0 / 9.0, y + k1 * 2.0 / 9.0);
            double k3 = stepUsed * derivative.getValue(currentX + stepUsed / 3.0, y + (k1 + 3.0 * k2) / 12.0);
            double k4 = stepUsed * derivative.getValue(currentX + 3.0 * stepUsed / 4.0, y + (69.0 * k1 - 243.0 * k2 + 270.0 * k3) / 128.0);
            double k5 = stepUsed * derivative.getValue(currentX + stepUsed, y - 17.0 * k1 / 12.0 + 27.0 * k2 / 4 - 27.0 * k3 / 5.0 + 16.0 * k4 / 15.0);
            double k6 = stepUsed * derivative.getValue(currentX + 5.0 * stepUsed / 6.0, y + 65.0 * k1 / 432.0 - 5.0 * k2 / 16.0 + 13.0 * k3 / 16.0 + 4.0 * k4 / 27.0 + 5.0 * k5 / 144.0);

            y = y + 47.0 * k1 / 450.0 + 12.0 * k3 / 25.0 + 32.0 * k4 / 225.0 + k5 / 30.0 + 6.0 * k6 / 25.0;
            double TE = Math.abs(-1.0 * k1 / 150.0 + 3.0 * k3 / 100.0 - 16.0 * k4 / 75.0 - k5 / 20.0 + 6.0 * k6 / 25.0);
            double absTE = Math.abs(TE);
            double nawias = Math.pow((0.5 / absTE), 0.2);
            double newStep = 0.9 * stepUsed * nawias;

            currentX += stepUsed;

            if (absTE <= 0.5) {
                if (absTE <= 0.01) {
                    absTE += 0.01;
                    nawias = Math.pow((0.5 / absTE), 0.2);
                    newStep = 0.9 * stepUsed * nawias;
                    stepUsed = newStep;

                    System.out.println("#### Długośc nowego kroku to : " + stepUsed + " ####");
                    System.out.println("*RKF5* Calculating x " + (currentX) + " y " + y);
                } else {
                    stepUsed = newStep;
                    currentX += stepUsed;
                }
                if (currentX + stepUsed > lastX) {
                    stepUsed = lastX - currentX;

                }
            } else {
                stepUsed = newStep;
                currentX += stepUsed;
                System.out.println("#### Długośc nowego kroku to : " + stepUsed + " ####");
                System.out.println("*RKF5* Calculating x " + (currentX) + " y " + y);
            }


            sleep(10);
            if (stepUsed == 0.0) {
                currentX = lastX + 1;
            }

        }


    }
}


