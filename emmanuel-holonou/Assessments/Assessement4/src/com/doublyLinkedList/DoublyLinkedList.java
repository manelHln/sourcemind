package com.doublyLinkedList;

import com.database.Connect;
import com.exception.DllException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoublyLinkedList<E> implements DllOperations<E>, DllDatabaseOperations {
    private Node<E> head;
    private Node<E> tail;
    private static int size;

    private Connect conn;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        conn = Connect.getInstance("jok3r", "joker123");
    }

    // Add an element to the end of the list
    @Override
    public void append(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail != null) {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;

        if (head == null) {
            head = tail;
        }
        ++size;
    }


    // Add element to the beginning of the list
    @Override
    public void prepend(E data) {
        Node<E> newNode = new Node<>(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        ++size;
    }


    // Delete element from list
    @Override
    public void remove(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                break;
            }
            current = current.next;
        }
    }

    @Override
    public void removeAtIndex(int index) throws DllException {
        if (index < 0 || index >= size) {
            throw new DllException("Index out of bounds!");
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> node = get(index);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }
    }


    @Override
    public void insertAtIndex(int index, E data) throws DllException {
        if (index < 0 || index >= size) throw new DllException("Index out of bound!");
        if (index == 0) {
            prepend(data);
        } else if (index == size - 1) {
            append(data);
        } else {
            Node<E> node = get(index);
            Node<E> newNode = new Node<>(data);
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev.next = newNode;
            node.prev = newNode;
        }

        size++;
    }

    @Override
    public E getFirst() {
        return head.data;
    }

    @Override
    public E getLast() {
        return tail.data;
    }

    @Override
    public void removeFirst() throws DllException {
        if (size == 0) {
            throw new DllException("Cannot remove from an empty list!");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> currentHead = head;
            head = currentHead.next;
            head.prev = null;
        }
        --size;
    }

    @Override
    public void removeLast() throws DllException {
        if (size == 0) {
            throw new DllException("Cannot remove from an empty list!");
        }
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            Node<E> currentTail = tail;
            tail = currentTail.prev;
            tail.next = null;
        }
        --size;
    }

    @Override
    public Node<E> get(int index) throws DllException {
        if (size == 0 || index >= size) {
            throw new DllException("Out of bound!");
        }
        if (index == 1) return head;
        if (index == size - 1) return tail;
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append("\n");
            }
            current = current.next;
        }
        return sb.toString();
    }


    @Override
    public void save(int depLoc, String depDate, int arrLoc, String arrDate) {
        try (PreparedStatement statement = conn.getConnection().prepareStatement("INSERT INTO flight(departure_location_id, dep_date, arr_date, arrival_location_id) VALUES(?, ?, ?, ?)")) {
            statement.setInt(1, depLoc);
            statement.setString(2, depDate);
            statement.setInt(3, arrLoc);
            statement.setString(4, arrDate);
            ResultSet resultSet = statement.executeQuery();
            resultSet.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void load() {

    }
}
