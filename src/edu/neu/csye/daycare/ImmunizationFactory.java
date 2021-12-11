package edu.neu.csye.daycare;

import java.util.Date;
import java.util.List;

public abstract class ImmunizationFactory {

    public abstract Immunization getObject(String name, List<Date> d, int age);

}
