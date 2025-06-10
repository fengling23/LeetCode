package com.leetcode.array;

import java.util.ArrayList;

public class MyArrayList<E> {
    private E[] elements;
    private int size;
    // 默认初始容量
    private static final int INIT_CAP = 10;

    public MyArrayList(){
        this(INIT_CAP);
    }

    public MyArrayList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("capcity must be >= 0");
        }
        elements = (E[])new Object[capacity];
        size = 0;
    }

    public void addLast(E element) {
        if (size == elements.length){
            resize(2*size);
        }
        elements[size] = element;
        size++;
    }

    public void addFirst(E element) {
        add(element, 0);
    }

    public void add(E element, int index) {
        if(checkPositionIndex(index)) {
            throw new IndexOutOfBoundsException("index out of bond");
        }

        if (size == elements.length){
            resize(2*size);
        }

        for( int i = size-1; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void resize(int new_cap) {
        E[] temp =  (E[]) new Object[new_cap];
        for (int i = 0; i < size; i++){
            temp[i] = elements[i];
        }
        elements = temp;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E remove(int index){
        if(checkElementIndex(index)) {
            throw new IndexOutOfBoundsException("index " + index + " is out of bounds for length " + size);
        }
        E element = elements[index];
        for(int i = index; i < size -1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1] = null; //清除引用
        size--;
        return element;
    }

    public E removeLast() {
        if (size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        E element = elements[size - 1];
        elements[size - 1] = null; // 清除引用
        size--;
        return element;
    }

    public boolean checkElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public boolean checkPositionIndex(int index) {
        //添加元素的时候index可以等于size
        return index >= 0 && index <= size;
    }




}
