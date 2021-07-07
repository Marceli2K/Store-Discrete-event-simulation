package mitsk.simulation.continuous.rk;

import mitsk.simulation.continuous.rk.relations.Function;

public class _2B extends Function {

    @Override
    public double getValue(double x, double y) {
        return 1-(x*x);
    }
}
