package mitsk.simulation.continuous.rk;

import mitsk.simulation.continuous.rk.relations.Function;

public class _3 extends Function {

    @Override
    public double getValue(double x, double y) {
        return (6-2*x/y);
    }
}
