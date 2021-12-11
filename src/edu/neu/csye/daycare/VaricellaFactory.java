package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class VaricellaFactory extends ImmunizationFactory {

    private static VaricellaFactory instance;

    private VaricellaFactory() {
        instance = null;
    }
    public static VaricellaFactory getInstance() {
        if(instance == null) {
            instance = new VaricellaFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new Varicella(name, d, age);
    }

}
