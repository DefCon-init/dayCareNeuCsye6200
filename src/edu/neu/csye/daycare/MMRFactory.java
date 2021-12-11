package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class MMRFactory extends ImmunizationFactory {

    private static MMRFactory instance;

    private MMRFactory() {
        instance = null;
    }
    public static MMRFactory getInstance() {
        if(instance == null) {
            instance = new MMRFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new MMR(name, d, age);
    }
}