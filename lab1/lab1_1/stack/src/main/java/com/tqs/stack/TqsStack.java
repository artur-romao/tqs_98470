package com.tqs.stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack<T> {
    
    private Integer limit = null;
    private ArrayList<T> list = new ArrayList<T>();

    public TqsStack() {}

    public TqsStack(int limit) {
        this.limit = limit;
    }

    public void push(T x) {
        if (size() == limit) throw new IllegalStateException();
        list.add(x);
    }

    public T pop() {
        try {
            T val = list.get(size() - 1);
            list.remove(size() - 1);
            return val;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
     
    }

    public T peek() {
        T val;
        try {
            val = list.get(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        return val;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        if (size() == 0) return true;
        return false;
    }

}
