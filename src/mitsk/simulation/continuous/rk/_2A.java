package mitsk.simulation.continuous.rk;

import mitsk.simulation.continuous.rk.relations.Function;

public class _2A extends Function {

    @Override
    public double getValue(double x, double y) {
        return 3 * x + (x*x);
    }
}
