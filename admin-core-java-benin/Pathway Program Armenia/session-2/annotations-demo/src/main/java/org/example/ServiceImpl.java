package org.example;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    @Override
    @Measure
    public List<String> getContacts() {
        System.out.println("Will load contacts from database");
        return new ArrayList<>();
    }

    @Override
    public void save(String name) {
        System.out.println("Will write to database");
    }
}
