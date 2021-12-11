package edu.neu.csye.daycare;

public abstract class PersonFactory {

    public abstract Person getObject(String csvData);

    public abstract Person getObject();
}
