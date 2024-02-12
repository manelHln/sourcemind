package com.doublyLinkedList;

import com.exception.DllException;

public interface DllOperations<E> {
    public void append(E data) throws DllException;
    public void prepend(E data) throws DllException;
    public void remove(E data) throws DllException;
    public void removeAtIndex(int index) throws DllException;
    public void insertAtIndex(int index, E data) throws DllException;
    public E getFirst() throws DllException;
    public E getLast() throws DllException;
    public void removeFirst() throws DllException;
    public void removeLast() throws DllException;
    public Node<E> get(int index) throws DllException;

    int getSize();
}
