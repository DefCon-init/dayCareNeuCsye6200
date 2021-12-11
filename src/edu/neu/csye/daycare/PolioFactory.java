package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class PolioFactory extends ImmunizationFactory {

    private static PolioFactory instance;

    private PolioFactory() {
        instance = null;
    }
    public static PolioFactory getInstance() {
        if(instance == null) {
            instance = new PolioFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new Polio(name, d, age);
    }
}
