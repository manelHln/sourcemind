package org.example;

import java.util.List;

public interface Service {
    List<String> getContacts();

    void save(String name);
}
