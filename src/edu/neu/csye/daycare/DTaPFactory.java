package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class DTaPFactory extends ImmunizationFactory {

    private static DTaPFactory instance;

    private DTaPFactory() {
        instance = null;
    }
    public static DTaPFactory getInstance() {
        if(instance == null) {
            instance = new DTaPFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new DTaP(name, d, age);
    }
}
