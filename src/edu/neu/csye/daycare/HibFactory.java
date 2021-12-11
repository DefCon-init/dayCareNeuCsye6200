package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class HibFactory extends ImmunizationFactory {

    private static HibFactory instance;

    private HibFactory() {
        instance = null;
    }
    public static HibFactory getInstance() {
        if(instance == null) {
            instance = new HibFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new Hib(name, d, age);
    }

}
