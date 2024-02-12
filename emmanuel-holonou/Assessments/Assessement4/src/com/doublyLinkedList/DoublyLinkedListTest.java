package com.doublyLinkedList;

import com.exception.DllException;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> dll;

    @Before
    public void setUp(){
        dll = new DoublyLinkedList<>();
    }


    @Test
    public void append() {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        assertEquals(1, (int) dll.getFirst());
        assertEquals(5, (int) dll.getLast());
    }

    @Test
    public void prepend() {
        dll.prepend(6);
        dll.prepend(7);
        dll.prepend(8);
        dll.prepend(9);
        dll.prepend(10);
        assertEquals(10, (int) dll.getFirst());
        assertEquals(6, (int) dll.getLast());
    }

    @Test
    public void remove() {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.remove(3);
        assertEquals(4, dll.getSize());
    }

    @Test
    public void removeAtIndex() throws DllException {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.removeAtIndex(2);
    }

    @Test
    public void insertAtIndex() throws DllException {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.insertAtIndex(9, 11);
    }

    @Test
    public void getFirst() {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.getFirst();
        assertEquals(1, (int) dll.getFirst());
    }

    @Test
    public void getLast() {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.getLast();
        assertEquals(5, (int) dll.getLast());
    }

    @Test
    public void removeFirst() throws DllException {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.removeFirst();
        assertEquals(2, (int) dll.getFirst());
    }

    @Test
    public void removeLast() throws DllException {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.removeLast();
        assertEquals(4, (int) dll.getLast());
    }

    @Test
    public void get() throws DllException {
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.get(3);
    }

}