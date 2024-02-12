package com.doublyLinkedList;

public interface DllDatabaseOperations {
    void save(int depLoc, String depDate, int arrLoc, String arrDate);

    public void load();
}
