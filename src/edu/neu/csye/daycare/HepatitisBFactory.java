package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public class HepatitisBFactory extends ImmunizationFactory {

    private static HepatitisBFactory instance;

    private HepatitisBFactory() {
        instance = null;
    }
    public static HepatitisBFactory getInstance() {
        if(instance == null) {
            instance = new HepatitisBFactory();
        }
        return instance;
    }

    @Override
    public Immunization getObject(String name, List<Date> d, int age) {
        return new HepatitisB(name, d, age);
    }

}
